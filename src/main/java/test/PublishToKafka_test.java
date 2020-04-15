package test;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.logging.Logger; 
import task.PublishToKafka;


public class PublishToKafka_test 
{
	/*
	 Test class to test functions of PublishToKafka class. 
	*/
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger( PublishToKafka_test.class.getName()); 
		JSONParser jsonParser = new JSONParser();
		//Parsing the contents of the JSON file
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		Object incoming_json_data= jsonParser.parse(new FileReader("./resources_test/json_files/test.json"));
		PublishToKafka prod= new PublishToKafka();
	if(incoming_json_data instanceof JSONObject)
	{	
		jsonObject = (JSONObject) incoming_json_data;
		System.out.println("Content is JSON Object :\n"+jsonObject);
		//Publish json as string
		prod.publishjsonAsString("localhost:9092", "sumit_test", jsonObject.toString());
		//Publish json as jsonobject
		prod.publishjsonAsJsonObject("localhost:9092", "sumit_test", jsonObject);
	}
	
	else 
	{
		jsonArray= (JSONArray)incoming_json_data;
		System.out.println("Content of json Array :\n"+jsonArray);
		prod.publishjsonAsJsonArray("localhost:9092", "sumit_test", jsonArray);
	}
}}
