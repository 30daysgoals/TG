package commons;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import com.google.common.reflect.TypeToken;

public class Utilities {
	private static Gson gson = new Gson();
	
	public static String getJsonRequestBody(String path) {
		try {
			Type type = new TypeToken<Map<String,Object>>(){
			}.getType();
			
			String jsonData =gson.toJson(
					((Map<String,Object>) gson.fromJson(new String (Files.readAllBytes(Paths.get(path))),type)));
			return jsonData;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

public static String getRequestBody(String path) {
	try {
		return new String (Files.readAllBytes(Paths.get(path)));
	} catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

public static String getResponseBody(String path) {
	try {
		return new String (Files.readAllBytes(Paths.get(path)));
	} catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

}
