package assertions;

import java.io.File;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import commons.FlatMap;

/*
Author : Sumit Kumar
This public class provides function that perform full json compare assertions.
/*
Below function check if the 2 json are same or not
*/

public class Compare2Json 
{

	public boolean comparejson(String firstjson, String secondjson)
	{
		System.out.println("*********************STARTING JSON COMPARE**************************");
		FlatMap fmap = new FlatMap();
		Map<String, Object> firstjsonmap =fmap.flattenmap(firstjson);
		System.out.println("First Json map is :");
		firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("First map size "+firstjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		Map<String, Object> secondjsonmap =fmap.flattenmap(secondjson);
		System.out.println("Second Json map is :");
		secondjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("Second map size "+secondjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		MapDifference<String, Object> diffrences =Maps.difference(firstjsonmap,secondjsonmap);
		if(diffrences.entriesOnlyOnLeft().isEmpty() && diffrences.entriesOnlyOnRight().isEmpty() && diffrences.entriesDiffering().isEmpty())
		{
			System.out.println("Input Json are identical. \n ");
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return true;
		}
		else
		{
			System.out.println("Input Json are diffrent, diffrences are : \n " +diffrences.entriesDiffering());
			System.out.println("Entries only in first file are : \n " +diffrences.entriesOnlyOnLeft());
			System.out.println("Entries only in second file are : \n " +diffrences.entriesOnlyOnRight());
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return false;
		}
		
	}
	
	public boolean comparejson(JSONObject firstjson, JSONObject secondjson)
	{
		System.out.println("*********************STARTING JSON COMPARE**************************");
		FlatMap fmap = new FlatMap();
		Map<String, Object> firstjsonmap =fmap.flattenmap(firstjson.toString());
		System.out.println("First Json map is :");
		firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("First map size "+firstjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		Map<String, Object> secondjsonmap =fmap.flattenmap(secondjson.toString());
		System.out.println("Second Json map is :");
		secondjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("Second map size "+secondjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		MapDifference<String, Object> diffrences =Maps.difference(firstjsonmap,secondjsonmap);
		if(diffrences.entriesOnlyOnLeft().isEmpty() && diffrences.entriesOnlyOnRight().isEmpty() && diffrences.entriesDiffering().isEmpty())
		{
			System.out.println("Input Json are identical. \n ");
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return true;
		}
		else
		{
			System.out.println("Input Json are diffrent, diffrences are : \n " +diffrences.entriesDiffering());
			System.out.println("Entries only in first file are : \n " +diffrences.entriesOnlyOnLeft());
			System.out.println("Entries only in second file are : \n " +diffrences.entriesOnlyOnRight());
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return false;
		}
		
	}
	
	public boolean comparejson(JSONArray firstjson, JSONArray secondjson)
	{
		System.out.println("*********************STARTING JSON COMPARE**************************");
		FlatMap fmap = new FlatMap();
		Map<String, Object> firstjsonmap =fmap.flattenmap(firstjson.toString());
		System.out.println("First Json map is :");
		firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("First map size "+firstjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		Map<String, Object> secondjsonmap =fmap.flattenmap(secondjson.toString());
		System.out.println("Second Json map is :");
		secondjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("Second map size "+secondjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		MapDifference<String, Object> diffrences =Maps.difference(firstjsonmap,secondjsonmap);
		if(diffrences.entriesOnlyOnLeft().isEmpty() && diffrences.entriesOnlyOnRight().isEmpty() && diffrences.entriesDiffering().isEmpty())
		{
			System.out.println("Input Json are identical. \n ");
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return true;
		}
		else
		{
			System.out.println("Input Json are diffrent, diffrences are : \n " +diffrences.entriesDiffering());
			System.out.println("Entries only in first file are : \n " +diffrences.entriesOnlyOnLeft());
			System.out.println("Entries only in second file are : \n " +diffrences.entriesOnlyOnRight());
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return false;
		}
		
	}
	
	public boolean comparejson(JSONObject firstjson, JSONArray secondjson)
	{
		System.out.println("*********************STARTING JSON COMPARE**************************");
		FlatMap fmap = new FlatMap();
		Map<String, Object> firstjsonmap =fmap.flattenmap(firstjson.toString());
		System.out.println("First Json map is :");
		firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("First map size "+firstjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		Map<String, Object> secondjsonmap =fmap.flattenmap(secondjson.toString());
		System.out.println("Second Json map is :");
		secondjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("Second map size "+secondjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		MapDifference<String, Object> diffrences =Maps.difference(firstjsonmap,secondjsonmap);
		if(diffrences.entriesOnlyOnLeft().isEmpty() && diffrences.entriesOnlyOnRight().isEmpty() && diffrences.entriesDiffering().isEmpty())
		{
			System.out.println("Input Json are identical. \n ");
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return true;
		}
		else
		{
			System.out.println("Input Json are diffrent, diffrences are : \n " +diffrences.entriesDiffering());
			System.out.println("Entries only in first file are : \n " +diffrences.entriesOnlyOnLeft());
			System.out.println("Entries only in second file are : \n " +diffrences.entriesOnlyOnRight());
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return false;
		}
		
	}
	
	public boolean comparejson(File firstjsonfile, File secondjsonfile) throws Exception
	{
		System.out.println("*********************STARTING JSON COMPARE**************************");
		String firstjson=FileUtils.readFileToString(firstjsonfile, "UTF-8");
		String secondjson=FileUtils.readFileToString(secondjsonfile, "UTF-8");
		FlatMap fmap = new FlatMap();
		Map<String, Object> firstjsonmap =fmap.flattenmap(firstjson);
		System.out.println("First Json map is :");
		firstjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("First map size "+firstjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		Map<String, Object> secondjsonmap =fmap.flattenmap(secondjson);
		System.out.println("Second Json map is :");
		secondjsonmap.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("Second map size "+secondjsonmap.size());
		System.out.println("--------------------------------------------------------------------");
		MapDifference<String, Object> diffrences =Maps.difference(firstjsonmap,secondjsonmap);
		if(diffrences.entriesOnlyOnLeft().isEmpty() && diffrences.entriesOnlyOnRight().isEmpty() && diffrences.entriesDiffering().isEmpty())
		{
			System.out.println("Input Json are identical. \n ");
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return true;
		}
		else
		{
			System.out.println("Input Json are diffrent, diffrences are : \n " +diffrences.entriesDiffering());
			System.out.println("Entries only in first file are : \n " +diffrences.entriesOnlyOnLeft());
			System.out.println("Entries only in second file are : \n " +diffrences.entriesOnlyOnRight());
			System.out.println("******************COMPLETED JSON COMPARE*****************************");
			return false;
		}
		
	}
}
