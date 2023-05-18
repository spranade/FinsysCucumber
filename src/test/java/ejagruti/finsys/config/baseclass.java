package ejagruti.finsys.config;


import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ejagruti.finsys.config.PropertiesFileReader;

public class baseclass {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	
	
	/*public static void currentDateTime() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  
	} 
	This method for DateTime has changed to get below method which is for getting unique screenshot file names.
	*/ 
	

	
	
	
	public static PropertiesFileReader pfr=new PropertiesFileReader("parameters");
	
	public static String NormalizeString(String ParameterName) 
	{
		try
		{
		if(ParameterName.startsWith("_"))
		{
			return pfr.GetParameterValue(ParameterName);
		}
		else
		{
			return ParameterName;
		}
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	
	
	
}
