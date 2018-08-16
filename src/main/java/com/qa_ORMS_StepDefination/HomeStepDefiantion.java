package com.qa_ORMS_StepDefination;

import com.qa_ORMS_TestPages.HomePage;
import com.qa_ORMS_TestPages.OverPaymentSearchPage;
import com.qa_ORMS_Utility.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeStepDefiantion extends BaseClass {
	HomePage HP = new HomePage();
	
	@Given("^User Selects Search option under Overpayment$")
	public void user_Selects_Search_option_under_Overpayment() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HP.fn_NavigateToORMSSearch();
	}
	
	@Then("^User returns to Home Page$")
	public void user_returns_to_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions 
		 HP.fn_NaviageToHomepage();
	}

	@Then("^logout from the ORMS Application$")
	public void logout_from_the_ORMS_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HP.fn_logout();
	}
}
