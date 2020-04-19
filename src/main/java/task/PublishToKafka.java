package task;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import java.io.IOException;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
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
    
    //Publish Avro using avro serializer and schema registry
    public void publishavromessage(String brokers, String topicName, GenericRecord inputjson,String schemaregistry) throws IOException
    {
    	System.out.println("*********************STARTING KAFKA PRODUCER**************************");
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        
        String sasl_username = "avnadmin";
    	String sasl_password = "s5go4l4wq06mqbo4";
    	String jaasTemplate = "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"%s\" password=\"%s\";";
    	String jaasConfig = String.format(jaasTemplate, sasl_username, sasl_password);
    	
        properties.put("bootstrap.servers", brokers);
        /*properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("sasl.jaas.config", jaasConfig);
        properties.put("security.protocol", "SSL");
        properties.put("ssl.endpoint.identification.algorithm", "");
        properties.put("ssl.truststore.location", "client.truststore.jks");
        properties.put("ssl.truststore.password", "secret");
        properties.put("ssl.keystore.type", "PKCS12");
        properties.put("ssl.keystore.location", "client.keystore.p12");
        properties.put("ssl.keystore.password", "secret");
        properties.put("ssl.key.password", "secret"); */
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        // Serialize key/value pairs
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","io.confluent.kafka.serializers.KafkaAvroSerializer");
        properties.put("schema.registry.url",schemaregistry);
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, GenericRecord> producer = new KafkaProducer<String, GenericRecord>(properties);
        
        try {

        	GenericRecord jsonNode = inputjson;
            ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(topicName, jsonNode);
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