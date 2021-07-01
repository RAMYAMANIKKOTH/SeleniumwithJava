package testListners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import testBase.TestBase;

import testUtilities.TestUtils;

public class CustomListener  extends TestBase implements ITestListener,ISuiteListener {
	//public ExtentTest testi;
	
	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testi.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		testi.log(LogStatus.FAIL, testi.addScreenCapture(TestUtils.screenshotname));
		
		
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a> target=\"_blank\" href="+TestUtils.screenshotname+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a> target=\"_blank\" href="+TestUtils.screenshotname+"><img> src="+TestUtils.screenshotname+" height=200 width=200></img></a>");
		rep.endTest(testi);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {


		testi.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(testi);
		rep.flush();
		
	}


	public void onTestStart(ITestResult arg0) {

		testi = rep.startTest(arg0.getName().toUpperCase());
		if(!TestUtils.isTestRunnable(arg0.getName().toUpperCase(), excel))
		{
			throw  new SkipException("skipping because runmode is no");
			
		}
	
	}

	public void onTestSuccess(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		testi.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		testi.log(LogStatus.PASS, testi.addScreenCapture(TestUtils.screenshotname));
		testi.log(LogStatus.INFO, arg0.getName().toUpperCase()+"Clicked");
		
rep.endTest(testi);
		rep.flush();
		
	}


}
