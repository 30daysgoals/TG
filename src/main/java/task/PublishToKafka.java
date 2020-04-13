package task;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import java.io.IOException;

/*
This class provides method to publish string , json object and json array to kafka topic. 
*/

public class PublishToKafka
{
    public void publishjsonAsString(String brokers, String topicName, String inputjson) throws IOException
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
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        
        try {
         
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, inputjson);
            producer.send(record);
            System.out.println("String Message published to kafka topic :\n"+record);
            System.out.println("*********************MESSAGE PUSH TO TOPIC COMPLETED***********************");
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	producer.close();
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