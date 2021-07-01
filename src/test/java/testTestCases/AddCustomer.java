package testTestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.TestBase;
import testUtilities.TestUtils;

public class AddCustomer extends TestBase {
	
	
	@Test(dataProviderClass = TestUtils.class,dataProvider = "dp")
	public  void addCustomer(Hashtable<String,String> data) {
		driver.findElement(By.xpath(or.getProperty("addcustbtn"))).click();
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		driver.findElement(By.cssSelector("input[ng-model ='fName']")).sendKeys(data.get("firstname"));
		driver.findElement(By.cssSelector("input[ng-model ='lName']")).sendKeys(data.get("lastname"));
		driver.findElement(By.cssSelector("input[ng-model ='postCd']")).sendKeys(data.get("postalcode"));
		driver.findElement(By.cssSelector("button[type ='submit']")).click();
		
		Alert al = wt.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(al.getText().contains(data.get("alertmessage")));
		al.accept();
		
		Reporter.log("CustomerAdded success");
		testi.log(null, data.get("alertmessage"));
		
		
	}

}
