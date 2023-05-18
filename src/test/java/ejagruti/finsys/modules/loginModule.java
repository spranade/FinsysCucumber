package ejagruti.finsys.modules;

import org.apache.log4j.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ejagruti.finsys.config.Startup;
import ejagruti.finsys.config.baseclass;
import ejagruti.finsys.operations.LaunchApplication;
import ejagruti.finsys.operations.homepage;
import ejagruti.finsys.operations.loginpage;

public class loginModule {


	final static Logger logger=Logger.getLogger(loginModule.class);


//	@When("^user opens the \"([^\"]*)\" browser$")
	@When("^user opens the \"(.*)\" browser$")
	public void user_opens_the_browser(String browser) throws Throwable
	{
		LaunchApplication app = new LaunchApplication();
		//app.launchBrowser(browser, "E:\\selenium\\JARS\\chromedriver.exe");
		String val = baseclass.NormalizeString(browser);
		logger.info("Browser is launched "+val);
		if(val!=null)
			app.launchBrowser(val);		
		else
			app.launchBrowser(browser);
	}
	
	
//	@When("^user enter the url \"([^\"]*)\"$")
	@And("^user enter the url \"(.*)\"$")
	public void user_enter_the_url(String url) throws Throwable {
		LaunchApplication app = new LaunchApplication();
		//app.launchApp(url);
		
		String val = baseclass.NormalizeString(url);
		logger.info("Application is launched "+val);
		if(val!=null)
			app.launchApp(val);
		else
			app.launchApp(url);
	}

	@Given("^user is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable {
		loginpage lp = new loginpage(Startup.wd);
		lp.verifyloginPage();
		logger.info("user is on the application login page ");
	}
	
	@Then("^user is on the same login page$")
	public void user_is_on_the_same_login_page() throws Throwable {
		loginpage lp = new loginpage(Startup.wd);
		lp.verifyloginPage();
	}

//	@When("^user enters \"([^\"]*)\" as username$")
	@When("^user enters \"(.*)\" as username$")
	public void user_enters_as_username(String uname) throws Throwable {
		String val = baseclass.NormalizeString(uname);
		loginpage lp = new loginpage(Startup.wd);
		if(val!=null)
			lp.enterUsername(val);
		else
			lp.enterUsername(uname);
	}

//	@When("^user enters \"([^\"]*)\" as password$")
	@And("^user enters \"(.*)\" as password$")
	public void user_enters_as_password(String pass) throws Throwable {
		String val = baseclass.NormalizeString(pass);
		loginpage lp = new loginpage(Startup.wd);
		if(val!=null)
			lp.enterPassword(val);
		else
			lp.enterPassword(pass);
	}

//	@When("^user clicks on login button$")
	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		loginpage lp = new loginpage(Startup.wd);
		lp.clickLoginButton();
	}

	@Then("^user is on the application home page$")
	public void user_is_on_the_application_home_page() throws Throwable {
	   homepage hp = new homepage(Startup.wd);
	   hp.verifyHomePage();
	   hp.verifytitle();	
	}

//	@Then("^user gets the message starting with \"([^\"]*)\" on the top$")
	@And("user gets the message starting with \"(.*)\" on the top$")
	public void user_gets_the_message_starting_with_on_the_top(String heading) throws Throwable {
		homepage hp = new homepage(Startup.wd);
		hp.verifyPageHeading(heading);
	}
	
	@And("user gets the message starting with \"(.*)\" on the bottom$")
	public void user_gets_the_message_starting_with_on_the_bottom(String heading) throws Throwable {
		loginpage lp = new loginpage(Startup.wd);
		lp.verifyloginPage();
	}
	
}


