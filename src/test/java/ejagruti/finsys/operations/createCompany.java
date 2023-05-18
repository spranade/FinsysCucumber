package ejagruti.finsys.operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ejagruti.finsys.library.Context;
import ejagruti.finsys.library.TestContext;

public class createCompany {
	TestContext testContext;
	//public String user_name = null;

	public createCompany(WebDriver wd) {
		// TODO Auto-generated constructor stub		
		PageFactory.initElements(wd, this);
	}
	
	public createCompany(TestContext testContext) {
		this.testContext = testContext;
	}
	
	//String productName = (String)testContext.scenarioContext.getContext(Context.USER_NAME);
    
	
}
