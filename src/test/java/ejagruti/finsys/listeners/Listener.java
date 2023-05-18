package ejagruti.finsys.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import ejagruti.finsys.config.TestBase;

public abstract class Listener extends TestBase implements ITestListener {
/*

	public void onTestStart (ITestResult result) 
	{
		//test = new ExtentTest(result.getName().toUpperCase(), result.getName().toUpperCase());
		
		test = rep.startTest(result.getName().toUpperCase());
	}
	
	public void onTestSuccess(ITestResult result) {
	
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS ");
		rep.endTest(test);
		rep.flush();
		
	}
	
	public void onTestFailure(ITestResult result) {
	
	System.out.println(result.getName() + "====>> is failing. Please refer screenshot");
	test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Fails with Exception : " + result.getThrowable());
	rep.endTest(test);
	rep.flush();
	
	try{
		test.log(LogStatus.FAIL,test.addScreenCapture(TestBase.CaptureScreenshot (result.getName() )));
	}
	catch(Exception e)
	{
		System.out.println("Could not capture Screenshot " + e.getLocalizedMessage());
		e.printStackTrace();
	}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}
	
	public void onStart(ITestContext context)
	{
		Runtime rt = Runtime.getRuntime();
		try{
			Process proc = rt.exec("taskkill /im" + prop.getProperty("browser-kill") + ".exe /f /t");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context)
	{
		
	}
*/

}
