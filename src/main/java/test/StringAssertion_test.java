package test;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import assertions.StringAssertion;



public class StringAssertion_test 
{
	/*
	 Test class to test functions of StringAssertion class. 
	*/
	
	public static void main(String[] args) throws Exception {
	JSONParser jsonParser = new JSONParser();
	//Parsing the contents of the JSON file
	JSONObject jsonObject=null;
	JSONArray jsonArray=null;
	String expectedValue = "e-mail: KRISHNA_kasyap@gmail.com";
	
	Object incoming_json_data= jsonParser.parse(new FileReader("./resources_test/json_files/test.json"));
	StringAssertion str_object=new StringAssertion();
	if(incoming_json_data instanceof JSONObject)
	{		
	jsonObject = (JSONObject) incoming_json_data;
	System.out.println("========================TEST ASSERT CONTAINS - START==========================");
	str_object.assertContains(jsonObject.toString(), expectedValue);
	System.out.println("========================TEST ASSERT CONTAINS - END============================");
	
	System.out.println("=================TEST ASSERT CONTAINS IGNORE CASE - START=====================");
	str_object.assertContains_ignorecase(jsonObject.toString(), expectedValue);
	System.out.println("=================TEST ASSERT CONTAINS IGNORE CASE - END=======================");
	}
	
	else 
	{

		jsonArray= (JSONArray)incoming_json_data;
		System.out.println("Content of json Array :\n"+jsonArray);
		System.out.println("========================TEST ASSERT CONTAINS - START==========================");
		str_object.assertContains(jsonArray.toString(), expectedValue);
		System.out.println("========================TEST ASSERT CONTAINS - END============================");
		
		System.out.println("=================TEST ASSERT CONTAINS IGNORE CASE - START=====================");
		str_object.assertContains_ignorecase(jsonArray.toString(), expectedValue);
		System.out.println("=================TEST ASSERT CONTAINS IGNORE CASE - END=======================");
		
	}
}}
