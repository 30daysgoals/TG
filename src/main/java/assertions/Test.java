package assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import commons.FlatMap;
import task.PublishToKafka;


public class Test 
{
	
	
	public static void main(String[] args) throws Exception {
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
	//FlatMap fmap = new FlatMap();
	//Map<String, Object> firstjsonmap =fmap.flattenmap(jsonObject.toString());
	//firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
	//str_object.assertContains(jsonObject.toString(), expectedValue);
	//str_object.assertContains_ignorecase(jsonObject.toString(), expectedValue);
	//PublishToKafka prod= new PublishToKafka();
	//prod.publishjsonAsString("localhost:9092", "sumit_test", jsonObject.toString());
	//prod.publishjsonAsJsonObject("localhost:9092", "sumit_test", jsonObject);
	//Object incoming_json_data2= jsonParser.parse(new FileReader("./files/test2.json"));
	//JSONObject jsonObject2 = (JSONObject) incoming_json_data2;
	Compare2Json compare=new Compare2Json();
	File file1 =new File("./files/test.json");
	File file2 =new File("./files/test2.json");
	compare.comparejson(file1,file2);
	//boolean compareoutcome =compare.comparejson(jsonObject.toString(), jsonObject2.toString());
	}
	
	else 
	{

		jsonArray= (JSONArray)incoming_json_data;
	//Response res=(Response) jsonArray;
		System.out.println("Content of json Array :\n"+jsonArray);
		//AssertJsonPath exp_object=new AssertJsonPath();
		//exp_object.assertJsonpath(jsonArray, jsonExp,expectedValue);
		//PublishToKafka prod= new PublishToKafka();
		//prod.publishjsonAsJsonArray("localhost:9092", "sumit_test", jsonArray);
		Compare2Json compare=new Compare2Json();
		//compare.comparejson(jsonArray.toString(), jsonArray.toString());
		File file1 =new File("./files/test.json");
		File file2 =new File("./files/test2.json");
		compare.comparejson(file1,file2);
	}
}}
