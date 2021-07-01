package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testUtilities.ExcelReader;
import testUtilities.ExtentManager;



public class TestBase {
	
		public static WebDriver driver;
		public static Properties config = new Properties();
		public static Properties or = new Properties();		
		public static FileInputStream file11;
		public static Logger log =  Logger.getLogger("devpinoyLogger");
		public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
		public static WebDriverWait wt;
		public static ExtentReports rep = ExtentManager.getInstance();
		
		public static ExtentTest testi  ;

		
		@BeforeSuite
		
		public void setup() throws FileNotFoundException{
			
			
		if(driver == null); {

		file11 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\config.properties");
		try {
			config.load(file11);
			log.debug("Config file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file11 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\or.properties");
		
		try {
			or.load(file11);
			log.debug("locator file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(config.getProperty("Browser").equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\executables\\chromedriver.exe");
			
			driver = new ChromeDriver();}
			
		
	
		driver.get(config.getProperty("URL"));
		log.debug("OPened URL loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 wt = new WebDriverWait(driver,30);
		
	
	

		}}
		public boolean isElementPresent(By by) {
			
			try {
				
				driver.findElement(by);
				return true;
			} catch(NoSuchElementException e) {
			
			return false;
			
			
			
			
			
		
}}
		static WebElement dropdown;
		public  void select(String locator, String value) {
			dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
			
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
		}
		public  void click(String locator) {
			
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
			testi.log(LogStatus.INFO, "Clicked");
			
			
			
		}
		
}