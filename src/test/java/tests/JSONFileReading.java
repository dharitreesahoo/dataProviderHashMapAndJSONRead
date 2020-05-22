package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReading {
	public static Object readDataFromJSON(String path ,  String TC, String keyVal) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(path));

		JSONObject jsonObject = (JSONObject) obj;
		 Map names = ((Map)jsonObject.get(TC)); 
		 Object data = names.get(keyVal);
		 return data;
	}
}
