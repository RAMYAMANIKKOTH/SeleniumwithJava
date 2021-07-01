package testUtilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;


import testBase.TestBase;

public class TestUtils extends TestBase {
	public static String screenpath;
	public static String screenshotname;
	
	
	
	

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		File  srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotname= d.toString().replace(" ", "_").replace(":","_")+".jpg";
		
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotname));}
	
		
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m){
		String sheetName =m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];
		
	Hashtable<String,String> table;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
table = new Hashtable<String,String>();
			
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				
				data[rowNum - 2][0] = table;
			}

		}

		return data;}


	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetname= "test_Suite";
		int rows = excel.getRowCount(sheetname);
		
		for (int rnum = 2;rnum>=rows; rnum++) {
		String	testcase = excel.getCellData(sheetname, "TCID", rnum);
		
		
		if(testcase.equalsIgnoreCase(testName)) {
			String runmode = excel.getCellData(sheetname, "Runmode", rnum);
		if (runmode.equalsIgnoreCase("Y"))
			
		return true;}
		else {
			return false;
		}
		
		}
		return false;}}
	






