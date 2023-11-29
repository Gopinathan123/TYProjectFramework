package Practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ReadDataFromJsonTest {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader filepath=new FileReader(".\\src\\test\\resources\\JSONRead.json");
		
		JSONParser jsonp= new JSONParser();
		Object obj=jsonp.parse(filepath);
		//read data from json file
		JSONObject map=(JSONObject) obj;
		
		System.out.println(map.get("Browser"));
		System.out.println(map.get("URL"));
		System.out.println(map.get("username"));
		System.out.println(map.get("Password"));
	}

}
