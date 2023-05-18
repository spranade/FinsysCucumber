package ejagruti.finsys.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ejagruti.finsys.config.Startup;


public class homepage {
	
	public homepage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@title='Manage Company']")
	WebElement managecompanylink;
	
	@FindBy(how=How.XPATH, using="//div/a[contains (text(),'LOGOUT')]")
	WebElement logoutLink;
	
	
	public void verifyHomePage()
	{
		
		if (logoutLink.isDisplayed())
		System.out.println("Logout link is displayed");
		
	}

	@FindBy(how=How.XPATH,using="//div/span[contains (text(), 'Welcome dummy[FM]')]")
	WebElement pageheading;
	public void verifyPageHeading(String heading)
	{
		String h = pageheading.getText();		
		System.out.println(h);
		if(h.contains(heading))
			System.out.println("Heading is verified");
		else
			System.out.println("Heading is wrong");
	}
	

	public void verifytitle() throws Exception
	{
		Thread.sleep(2000);
		Assert.assertEquals(Startup.wd.getTitle(), "FinSys (SBDC) - eJagruti Educational Services", "Title is verified");
	}
	
	public static void main(String args[]) throws Throwable
	{
		
		LaunchApplication app = new LaunchApplication();
		//app.launchBrowser("Chrome", "E:\\selenium\\JARS\\chromedriver.exe");
		
		app.launchBrowser("Chrome");
		app.launchApp("http://localhost:80/finsys/login.html");
		
		loginpage lp = new loginpage(Startup.wd);
		lp.enterUsername("dummyfm");		
		lp.enterPassword("passw0rd");
		
		lp.clickLoginButton();
		homepage hm = new homepage(Startup.wd);		
		hm.verifyPageHeading("welcome");
		hm.verifyHomePage();
		
	}
	
}
