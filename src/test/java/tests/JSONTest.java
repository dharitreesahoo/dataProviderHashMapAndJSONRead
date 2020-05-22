package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JSONTest {
	
	String filePath = "D:\\NewWorkspace\\HashMapDataProvider\\resources\\CreditRequest.json";
	
	@Test
	public void test1() throws FileNotFoundException, IOException, ParseException
	{
		
		String streetAddress = (String) JSONFileReading.readDataFromJSON(filePath , "TC001" ,  "streetAddress");
		System.out.println(streetAddress);
	}

}
