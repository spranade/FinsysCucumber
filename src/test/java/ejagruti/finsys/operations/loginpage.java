package ejagruti.finsys.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.Context;
import ejagruti.finsys.library.TestContext;
import junit.framework.Assert;

public class loginpage {
	
	TestContext testContext;
	public String user_name = null;

	public loginpage(WebDriver wd) {
		// TODO Auto-generated constructor stub		
		PageFactory.initElements(wd, this);
	}
	
	public loginpage(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement username;
	public void enterUsername(String uname){
//		testContext.scenarioContext.setContext(Context.USER_NAME, uname);
//		String U_Name = (String)testContext.scenarioContext.getContext(Context.USER_NAME);
//		System.out.println("=====>>>> User Name is =====>>>>"+U_Name);
		username.sendKeys(uname);
	}
	
	@FindBy(how=How.XPATH,using="//input[@type='password'][@placeholder='Password']")
	WebElement password;
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}
	
	@FindBy(how=How.XPATH,using="//div/a/span/span[contains (text(),Login)]")
	WebElement LoginButton;
	public void clickLoginButton(){
		LoginButton.click();
	}
	
	
	public void verifyloginPage()
	{		
		String title=Startup.wd.getTitle();
		Assert.assertEquals("SBDC - Small Business Development Co.", title);
		System.out.println("Login page is displayed");
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='error']")
	WebElement ErrorMessage;	
	public void verifyErrorMessage()
	{
		String err=ErrorMessage.getText();
		Assert.assertEquals("Please Enter Valid Username or Password!!!", err);
		System.out.println(ErrorMessage.getAttribute("innerhtml"));
		System.out.println(ErrorMessage.getText());
		
	}
}
