package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithHashMap {
	//This test case will use dataprovider test data1 .based on the sheet name it will fetch the values
	@Test(dataProvider = "testData1")
	public void test1(Map mapData) {
		System.out.println("Test Started========");
		System.out.println(mapData.get("username"));
		System.out.println(mapData.get("password"));
		System.out.println("Test ended========");
	}
	@Test(dataProvider = "testData2")
	public void test2(Map mapData) {
		System.out.println("Test Started========");
		System.out.println(mapData.get("firstName"));
		System.out.println(mapData.get("lastName"));
		System.out.println("Test ended========");
	}

	@DataProvider(name = "testData1")
	public Object[][] dataProviderMethod() throws Exception {
		String strSheetName = "UserData";
		String filePath = System.getProperty("user.dir") + "/resources/DataSheet.xlsx";
		Object[][] userData = getData(filePath, strSheetName);
		return userData;
	}
	@DataProvider(name = "testData2")
	public Object[][] dataProviderMethod2() throws Exception {
		String strSheetName = "loginData";
		String filePath = System.getProperty("user.dir") + "/resources/DataSheet.xlsx";
		Object[][] userData = getData(filePath, strSheetName);
		return userData;
	}

	//keep this code in excel solution
	public Object[][] getData(String filePath, String strSheetName) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(strSheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		// define a map and define an object array
		Object[][] obj = new Object[rowCount][1];

		for (int i = 0; i < rowCount; i++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int j = 0; j < colCount; j++) {
				dataMap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
			}
			obj[i][0] = dataMap;
		}
		return obj;
	}

}
