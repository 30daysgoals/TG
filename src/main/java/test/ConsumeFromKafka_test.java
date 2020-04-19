package test;
import java.time.Duration;
import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import task.ConsumeFromKafka;

public class ConsumeFromKafka_test 
{
	/*
	 Test class to test functions of import task.ConsumeFromKafka class - hold offset and value in map 
	*/
	
	public static void main(String[] args) throws Exception {

		ConsumeFromKafka consume=new ConsumeFromKafka();
		Duration time_ms=Duration.ofSeconds(1);
		System.out.println("Consuming From Topic sumit_test");
		KafkaConsumer<String, String> consumer=consume.consumejsonAsString("localhost:9092", "sumit_test", "test-consumer-group");
		int counter=0;
		HashMap<Long, String> hm= new HashMap<Long, String>();
		while (true) 
		{
		    ConsumerRecords<String, String> records = consumer.poll(time_ms);
		    records.forEach(record -> {
              /*  System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());*/
                hm.put(record.offset(), record.value());
            });
		    if (records == null || records.isEmpty()) {
		        counter++;
		         if (counter > 10)
		            break;
		      } else {
		        counter = 0;
		      }
		}
		 hm.forEach((k, v) -> System.out.println("Offset key is : " +k +":" + " Value key is : "+ v));
		//consumer.consumeperConversationId("localhost:9092", "sumit_test", "test-consumer-group","123456789");
	}
}