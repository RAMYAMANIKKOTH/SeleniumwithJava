package testTestCases;

import org.testng.annotations.Test;

import testBase.TestBase;
import testUtilities.TestUtils;

public class OpenAccount extends TestBase {
	
	
	
	@Test(dataProviderClass =  TestUtils.class,dataProvider = "dp" )
	public  void openAccount(String Customer, String Currency) {
		click("opencust");
		
		
		select("customer",Customer);
		
		select("currency",Currency);
	}

}
