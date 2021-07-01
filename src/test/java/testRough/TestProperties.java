package testRough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		
		Properties config = new Properties();
		
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\config.properties");
		config.load(file1);
		System.out.println(config.getProperty("Browser"));
	
		
		System.out.println(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\config.properties");
		
	
		

	}

}
