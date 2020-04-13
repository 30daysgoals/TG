package commons;
import java.util.Map; 
import com.github.wnameless.json.flattener.JsonFlattener;

/*
Author : Sumit Kumar
This public class provides method to flatten a input json
*/ 

public class FlatMap {
	public Map<String, Object> flattenmap(String sourcejson)
	{
		Map<String, Object> flattenedJsonMap =null;
		try {
 
			// JsonFlattener: A Java utility used to FLATTEN nested JSON objects
			flattenedJsonMap = JsonFlattener.flattenAsMap(sourcejson);
			//flattenedJsonMap.forEach((k, v) -> System.out.println(k + " : " + v));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flattenedJsonMap;
		
		
	}
 
}