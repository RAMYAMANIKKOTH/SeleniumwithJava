package testTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.TestBase;

public class LoginTest extends TestBase {
@Test
	public void Login() throws InterruptedException {
		
		click("BMlogin");
		
		Thread.sleep(1000);
		
		//driver.findElement(By.cssSelector(or.getProperty("addcustbtn"))).click();
		//Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addcustbtn"))),"Login not success");
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addcustbtn"))),"Login not successful");
		
		Reporter.log("Login successful");
		
	}
	
	
}
