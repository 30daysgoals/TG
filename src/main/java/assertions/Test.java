package assertions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import task.PublishToKafka;


public class Test 
{
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	//Parsing the contents of the JSON file
	JSONObject jsonObject=null;
	JSONArray jsonArray=null;
	String jsonExp = "$.contact[0]";
	String expectedValue = "e-mail: KRISHNA_kasyap@gmail.com";
	
	Object incoming_json_data= jsonParser.parse(new FileReader("./files/test.json"));
	if(incoming_json_data instanceof JSONObject)
	{
			
		jsonObject = (JSONObject) incoming_json_data;
    //Response res=(Response) jsonObject;
	System.out.println("Content is JSON Object :\n"+jsonObject);
	//AssertJsonPath exp_object=new AssertJsonPath();
	//StringAssertion str_object=new StringAssertion();
	//exp_object.assertJsonpath(jsonObject, jsonExp,expectedValue);
	
	//str_object.assertContains(jsonObject.toString(), expectedValue);
	//str_object.assertContains_ignorecase(jsonObject.toString(), expectedValue);
	//PublishToKafka prod= new PublishToKafka();
	//prod.publishjsonAsString("localhost:9092", "sumit_test", jsonObject.toString());
	//prod.publishjsonAsJsonObject("localhost:9092", "sumit_test", jsonObject);
	
	}
	
	else 
	{

		jsonArray= (JSONArray)incoming_json_data;
	//Response res=(Response) jsonArray;
		System.out.println("Content of json Array :\n"+jsonArray);
		//AssertJsonPath exp_object=new AssertJsonPath();
		//exp_object.assertJsonpath(jsonArray, jsonExp,expectedValue);
		PublishToKafka prod= new PublishToKafka();
		prod.publishjsonAsJsonArray("localhost:9092", "sumit_test", jsonArray);
	}
}}
