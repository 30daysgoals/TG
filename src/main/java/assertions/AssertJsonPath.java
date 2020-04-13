package assertions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.jayway.jsonpath.JsonPath;

public class AssertJsonPath 
{
	/*
	 Author: Sumit Kumar
	 This public class provides function that perform json path based assertions, it contains overloaded methods to 
	 accommodate json as string , as object and as array.
	*/

	//Below function takes a source json as string , a valid jpath expression and expected value for the jpath 
	public boolean  assertJsonpath(String sourceJson,String jPath, String expected_Value)
	{
		// TODO Auto-generated method stub
		System.out.println("*********************STARTING JSON PATH ASSERTION**************************");
		String node_value=JsonPath.read(sourceJson,jPath);
		if(node_value.equals(expected_Value))
		{
			System.out.println(" AssertJsonpath is TRUE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return true;
		}
		
		else
		{
			System.out.println(" AssertJsonpath is FALSE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return false;
		}
	}
	
	//Below function takes a source json as json object , a valid jpath expression and expected value for the jpath 
	public boolean  assertJsonpath(JSONObject sourceJson,String jPath, String expected_Value)
	{
		System.out.println("*********************STARTING JSON PATH ASSERTION**************************");
		// TODO Auto-generated method stub
		String node_value=JsonPath.read(sourceJson.toString(),jPath);
		if(node_value.equals(expected_Value))
		{
			System.out.println(" AssertJsonpath is TRUE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return true;
		}
		
		else
		{
			System.out.println(" AssertJsonpath is FALSE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return false;
		}
	}
	
	//Below function takes a source json as json array , a valid jpath expression and expected value for the jpath
	public boolean  assertJsonpath(JSONArray sourceJson,String jPath, String expected_Value)
	{
		System.out.println("*********************STARTING JSON PATH ASSERTION**************************");
		// TODO Auto-generated method stub
		String node_value=JsonPath.read(sourceJson.toString(),jPath);
		if(node_value.equals(expected_Value))
		{
			System.out.println(" AssertJsonpath is TRUE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return true;
		}
		
		else
		{
			System.out.println(" AssertJsonpath is TRUE.\n Expected Value is :"+expected_Value +"\n" +" Actual value is: " +node_value);
			System.out.println("*****************JSON PATH ASSERTION COMPLETED**************************");
			return false;
		}
	}
}
