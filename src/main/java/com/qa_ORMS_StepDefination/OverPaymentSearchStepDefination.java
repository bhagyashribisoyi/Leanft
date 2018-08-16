package com.qa_ORMS_StepDefination;

import com.qa_ORMS_DataManagement.ExcelReader;
import com.qa_ORMS_TestPages.OverPaymentSearchPage;
import com.qa_ORMS_Utility.BaseClass;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverPaymentSearchStepDefination extends BaseClass {
	ExcelReader ER = new ExcelReader();
	static String SheetName = "OverPayment_Search";
	OverPaymentSearchPage OPSP = new OverPaymentSearchPage();
	
	@When("^User makes a search with data present in excel sheet \"([^\"]*)\"$")
	public void user_makes_a_search_with_data_present_in_excel_sheet(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ER.ReadTestData(SheetName);
		String eODARID = ExcelReader.hm1.get(arg1).get("ODAR_ID");
		String eCLAIMID = ER.hm1.get(arg1).get("CLAIM_ID");
		String eTAXID = ER.hm1.get(arg1).get("TAX_ID");
		String eSUBSCRIBERID = ER.hm1.get(arg1).get("SUBSCRIBER_ID");
		OPSP.fn_searchOverPayment(eODARID,eCLAIMID,eTAXID,eSUBSCRIBERID);
		//Navigate to Menu bar
	
	}
	
	@Then("^OverPayment details should be displayed for \"([^\"]*)\"$")
	public void overpayment_details_should_be_displayed_for(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
				ER.ReadTestData(SheetName);
				String eScenario_Flow = ER.hm1.get(arg1).get("Scenario_Flow");
				OPSP.fn_validate_SearchResult(eScenario_Flow);
			}

	@Then("^OverPayment details should not  be displayed for \"([^\"]*)\"$")
	public void overpayment_details_should_not_be_displayed_for(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ER.ReadTestData(SheetName);
		String eScenario_Flow = ER.hm1.get(arg1).get("Scenario_Flow");
		OPSP.fn_validate_SearchResult(eScenario_Flow);
	}




}
