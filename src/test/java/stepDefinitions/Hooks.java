//package ejagruti.finsys.modules;

package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

//import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ejagruti.finsys.config.TestBase;
public class Hooks extends TestBase {	
	//TestContext testContext;	
	//public Hooks(TestContext context) {
		//testContext = context;
	//}

	@Before(order=0)
	public void beforeScenario(Scenario scenario) {
	    Reporter.assignAuthor("Swanand Ranade");
	}
	
	@After(order=1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-html-reports/screenshots/"+screenshotName+".png");
				
				//Copy taken screenshot from source location to destination location
				FileUtils.copyFile(sourcePath, destinationPath);   

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
	
	@After(order=0)
	public void AfterSteps() {
		//testContext.getWebDriverManager().quitDriver();

		TestBase.driver.quit();
	}
}
