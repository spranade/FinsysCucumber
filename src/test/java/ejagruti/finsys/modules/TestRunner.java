package ejagruti.finsys.modules;

import java.io.File;
import java.io.FileReader;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt",
		"html:target/cucumber-html-reports",
		"json:target/cucumber-reports/cucumber-json.json",
		"usage:target/cucumber-reports/cucumber-usage.json",
		"junit:target/cucumber-reports/cucumber-results.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		},
features = {"src/test/resources/features"},
//glue = {"src/test/java/stepDefinitions"},
//tags = { " ~@EndToEnd , @SmokeTest " },
tags = { "@test"} ,
monochrome = true,
strict = true,
dryRun = false
)

//public class TestRunner  {
public class TestRunner extends AbstractTestNGCucumberTests {
	
	 @AfterClass
	 public static void writeExtentReport() {
		 //String filename = "/src/test/resources/extent-config.xml";
		 //Reporter.loadXMLConfig(filename);
	 Reporter.loadXMLConfig(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "32 Bit");
     Reporter.setSystemInfo("Selenium", "3.141.59");
     Reporter.setSystemInfo("Maven", "3.9.1");
     Reporter.setSystemInfo("Java Version", "1.8.0_341");
	 }
	
	
/*

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        List<CucumberTagStatement> elements = cucumberFeatureWrapper.getCucumberFeature().getFeatureElements();

        for (Iterator<CucumberTagStatement> element = elements.iterator(); element.hasNext(); ) {
            //ToDo: Bring the scenario name from Excel sheet using the out-of-box library we have in utilities package
            //Pass the hardcoded scenario name

            CucumberTagStatement scenarioName = element.next();
            if (!scenarioName.getVisualName().equals("Scenario: Create Employee with all details")) {
                element.remove();
            }
        }

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        
    }
*/

}




/*
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions.Options(format = {"pretty", "html:target/html"}, features =
 * {"FeatureCollections"}, tags={"@SmokeTest"} ) public class runTest {
 * 
 * }
 * 
 * 
 * plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt", 
		"html:target/cucumber-html-reports","json:target/cucumber-reports/cucumber-json.json",
		"usage:target/cucumber-reports/cucumber-usage.json","junit:target/cucumber-reports/cucumber-results.xml" }
 * 
 */