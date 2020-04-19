package task;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.io.IOException;

/*
This class provides method to consume string , json object and json array to kafka topic. 
*/

public class ConsumeFromKafka
{
    public KafkaConsumer consumejsonAsString(String brokers, String topicName, String groupid) throws IOException
    {
    	System.out.println("*********************STARTING KAFKA CONSUMER**************************");
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.put("bootstrap.servers", brokers);
        properties.put("enable.auto.commit", "false");
        //properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("group.id", groupid);
        // Serialize key/value pairs
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("ConsumerConfig","from-beginning");  
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topicName));
		return consumer;
        
}
    
    public void consumeperConversationId(String brokers, String topicName, String groupid, String conversationid) throws IOException
    {
    	System.out.println("*********************STARTING KAFKA CONSUMER**************************");
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.put("bootstrap.servers", brokers);
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("group.id", groupid);
        // Serialize key/value pairs
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("ConsumerConfig","earliest");  
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topicName));
        System.out.println("Subscribed to topic and group id is " + topicName + groupid );
           
        while (true) {
           
           ConsumerRecords<String, String> records = consumer.poll(100);
              for (ConsumerRecord<String, String> record : records)
            	  if(record.value().contains(conversationid))
            	  {
                 System.out.printf("offset = %d, key = %s, value = %s\n", 
                 record.offset(), record.key(), record.value());
            	  }
              
        } 
       
       
}
    
    //Publish json as JSON object
    public void publishjsonAsJsonObject(String brokers, String topicName, JSONObject inputjson) throws IOException
    {
    	System.out.println("*********************STARTING KAFKA PRODUCER**************************");
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.put("bootstrap.servers", brokers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        // Serialize key/value pairs
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.connect.json.JsonSerializer");
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, JsonNode> producer = new KafkaProducer<String, JsonNode>(properties);
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {

            JsonNode jsonNode = objectMapper.valueToTree(inputjson);
            ProducerRecord<String, JsonNode> record = new ProducerRecord<String, JsonNode>(topicName, jsonNode);
            producer.send(record);
            System.out.println("Json Object Message published to kafka topic :\n"+record);
            System.out.println("*********************MESSAGE PUSH TO TOPIC COMPLETED***********************");
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	producer.close();
        }
    }
    
  //Publish json as JSON array
    public void publishjsonAsJsonArray(String brokers, String topicName, JSONArray inputjson) throws IOException
    {
    	System.out.println("*********************STARTING KAFKA PRODUCER**************************");
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.put("bootstrap.servers", brokers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        // Serialize key/value pairs
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.connect.json.JsonSerializer");
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, JsonNode> producer = new KafkaProducer<String, JsonNode>(properties);
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {

            JsonNode jsonNode = objectMapper.valueToTree(inputjson);
            ProducerRecord<String, JsonNode> record = new ProducerRecord<String, JsonNode>(topicName, jsonNode);
            producer.send(record);
            System.out.println("Json Object Message published to kafka topic :\n"+record);
            System.out.println("*********************MESSAGE PUSH TO TOPIC COMPLETED***********************");
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	producer.close();
        }
    }
    
    
}