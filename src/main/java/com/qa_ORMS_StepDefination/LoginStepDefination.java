package com.qa_ORMS_StepDefination;

import org.testng.Assert;

import com.qa_ORMS_DataManagement.PropertyFileReader;
import com.qa_ORMS_TestPages.LoginPage;
import com.qa_ORMS_Utility.BaseClass;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination extends BaseClass {
PropertyFileReader PR = new PropertyFileReader();
LoginPage LP = new LoginPage();


	@Given("^user is in login page$")
	public void user_is_in_login_page() throws Throwable {
		String pURL = PR.fn_ReadPropertyFile().getProperty("url");

		//navigate to ORMS Application
		BaseClass.Launch_Browser();
		LoginPage.fn_NavigateToURL(pURL);
         Thread.sleep(2000);
		//Login page title
		String PageTitle=browser.getTitle();  
	
	//	Assert.assertEquals("SiteMinder Password Services - en-US", PageTitle);   

	}

	@When("^entering username & password$")
	public void entering_username_password() throws Throwable {
		//Read username and password from property file
				String pUsername = PR.fn_ReadPropertyFile().getProperty("username");
				String pPassword = PR.fn_ReadPropertyFile().getProperty("password");

				//Login to Application
				LoginPage.fn_ORMSLogin(pUsername,pPassword);
	}

	@Then("^sucessful login to ORMS home page$")
	public void sucessful_login_to_ORMS_home_page() throws Throwable {
		String PageTitle=browser.getTitle();  
		System.out.println(PageTitle);
	   
	}
}
