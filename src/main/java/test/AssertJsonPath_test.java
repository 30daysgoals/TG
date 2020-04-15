package test;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import assertions.AssertJsonPath;



public class AssertJsonPath_test 
{
	/*
	 Test class to test functions of AssertJsonPath class. 
	*/
	
	public static void main(String[] args) throws Exception {
		JSONParser jsonParser = new JSONParser();
		//Parsing the contents of the JSON file
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		String jsonExp = "$.contact[0]";
		String expectedValue = "e-mail: KRISHNA_kasyap@gmail.com";
		
		Object incoming_json_data= jsonParser.parse(new FileReader("./resources_test/json_files/test.json"));
		AssertJsonPath exp_object=new AssertJsonPath();
	if(incoming_json_data instanceof JSONObject)
	{		
		jsonObject = (JSONObject) incoming_json_data;
	    //Response res=(Response) jsonObject;
		System.out.println("Content is JSON Object :\n"+jsonObject);
		System.out.println("========================TEST ASSERT JSON PATH - START========================="); 
		exp_object.assertJsonpath(jsonObject, jsonExp,expectedValue);
		System.out.println("========================TEST ASSERT JSON PATH - end===========================");
	}
	
	else 
	{
		jsonArray= (JSONArray)incoming_json_data;
		System.out.println("Content of json Array :\n"+jsonArray);
		System.out.println("========================TEST ASSERT JSON PATH - START========================="); 
		exp_object.assertJsonpath(jsonArray, jsonExp,expectedValue);
		System.out.println("========================TEST ASSERT JSON PATH - end===========================");
	}
}}
