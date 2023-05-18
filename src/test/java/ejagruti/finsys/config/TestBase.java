package ejagruti.finsys.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase
{
public static WebDriver driver;
public static Properties prop;
public static ExtentTest test;
public ExtentReports rep = ExtentManager.getInstance();
	public TestBase()
	{
	
		prop = new Properties();
		FileInputStream ip;
		FileOutputStream op=null;
		try
		{
			//ip = FileUtility.retrieveFileOrClasspathResourceAsStream("config\\config.properties");
			
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration.properties");
			
			try{
			prop.load(ip);
			}
			catch(IOException e)
			{
			e.printStackTrace();
			//throw new RuntimeException(e);
			}
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static String CaptureScreenshot( String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String dest = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";

			File destination = new File(dest);

			// FileUtils.copyFile(source, new
			// File("./Screenshots/"+screenshotName+".png"));

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot taken");
			System.out.println(dest);
			return dest;
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}

	}
	
	
}
