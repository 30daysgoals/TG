package test;
import java.io.File;
import java.io.FileReader;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import task.PublishToKafka;


public class PublishToKafka_test 
{
	/*
	 Test class to test functions of PublishToKafka class. 
	*/
	
	private static DataFileReader<GenericRecord> dataFileReader;

	public static void main(String[] args) throws Exception {
		
		JSONParser jsonParser = new JSONParser();
		//Parsing the contents of the JSON file
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		Object incoming_json_data= jsonParser.parse(new FileReader("./resources_test/json_files/test.json"));
		PublishToKafka prod= new PublishToKafka();
		
		//AVRO publish using schema registry - Schema registry is must for this to be used.
	/*	
		DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
		dataFileReader = new DataFileReader<>(new File("./resources_test/avro_files/test.avro"), datumReader);
		GenericRecord record = null;
		
		String registryUrl = "unused";
		while (dataFileReader.hasNext()) {
		    record = dataFileReader.next(record);
		    System.out.println(record);
		    prod.publishavromessage("localhost:9092", "sumit_test", record,registryUrl);
		    System.out.println(record);
		}
		*/
		
		
 // Below is code for publish JSON
	
	if(incoming_json_data instanceof JSONObject)
	{	
		jsonObject = (JSONObject) incoming_json_data;
		System.out.println("Content is JSON Object :\n"+jsonObject);
		//Publish json as string
		prod.publishjsonAsString("localhost:9092", "sumit_test", jsonObject.toString());
		//Publish json as jsonobject
		//prod.publishjsonAsJsonObject("localhost:9092", "sumit_test", jsonObject);
	}
	
	else 
	{
		jsonArray= (JSONArray)incoming_json_data;
		System.out.println("Content of json Array :\n"+jsonArray);
		prod.publishjsonAsJsonArray("localhost:9092", "sumit_test", jsonArray);
	} 

}}
