package ejagruti.finsys.operations;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.config.baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplication {

		
	
	
	//public void launchBrowser(String Browser,String filepath) 
	public void launchBrowser(String Browser) 
	{
		
		
		try{
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\parameters.properties");
			prop.load(ip);
			String Exe_Remote = prop.getProperty("_execute_remotely");
			if(Browser.equalsIgnoreCase("firefox"))
			{
			
				
				//System.setProperty("webdriver.firefox.marionette",filepath);
				if(Exe_Remote.equalsIgnoreCase("N"))
				{
				WebDriverManager.firefoxdriver().setup();
				Startup.wd = new FirefoxDriver();
				}
				else
				{
					DesiredCapabilities dc=new DesiredCapabilities("firefox", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
				}
			}
		
			else if(Browser.equalsIgnoreCase("Chrome"))
			{
				if(Exe_Remote.equalsIgnoreCase("N"))
				{
				//System.setProperty("webdriver.chrome.driver",filepath);
				WebDriverManager.chromedriver().setup();
				Startup.wd = new ChromeDriver();
				}
				else
				{
					DesiredCapabilities dc=new DesiredCapabilities("chrome", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
				}
				
			
			}
		
			else if(Browser.equalsIgnoreCase("IE"))
			{
				if(Exe_Remote.equalsIgnoreCase("N"))
				{
				//System.setProperty("webdriver.ie.driver",filepath);				
				WebDriverManager.iedriver().setup();
				Startup.wd = new InternetExplorerDriver();
			}
			else
			{
				DesiredCapabilities dc=new DesiredCapabilities("IE", "any",org.openqa.selenium.Platform.WINDOWS);
				Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
			}
			}
		}
	
	catch(Exception e)
	{
	}
		
		
		
	}
	
	
	public void launchApp(String url) 
	{
		
		Startup.wd.get(url);
		Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Startup.wd.manage().window().maximize();
		Startup.wd.manage().getCookies().clear();
		
	}
}
