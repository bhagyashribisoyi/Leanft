package com.qa_ORMS_TestPages;

import java.awt.image.RenderedImage;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.web.*;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.qa_ORMS_Utility.BaseClass;

public class OverPaymentSearchPage extends BaseClass {


	//Page Objects
	EditFieldDescription oOdarId = new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("overpaymentId").build();
	EditFieldDescription oClaimId = new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("claimId").build();
	EditFieldDescription oTaxId =new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("taxId").build();
	EditFieldDescription oSubscriber =new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("subscriber").build();

	ButtonDescription oSubmitBtn =new ButtonDescription.Builder()
			.buttonType("submit").tagName("INPUT").name("Search").build();
	ButtonDescription oClearBtn = new ButtonDescription.Builder()
			.buttonType("reset").tagName("BUTTON").name("Clear").build();

	//Page Actions

	public void fn_searchOverPayment(String ODAR_ID,String CLAIM_ID,String TAX_ID,String SUBSCRIBER_ID) throws GeneralLeanFtException, InterruptedException, ReportException
	{
		int counter = 0;

		if(ODAR_ID != null)
		{
			browser.describe(EditField.class,oOdarId).setValue(ODAR_ID);
		}
		else
		{
			counter ++;
		}

		if(CLAIM_ID != null)
		{
			browser.describe(EditField.class,oClaimId).setValue(CLAIM_ID);
		}
		else
		{
			counter ++;
		}
		
		if(TAX_ID != null)
		{
			browser.describe(EditField.class, oTaxId).setValue(TAX_ID);
		}
		else
		{
			counter ++;
		}
		
		if(SUBSCRIBER_ID != null)
		{
			browser.describe(EditField.class, oSubscriber).setValue(SUBSCRIBER_ID);
		}
		else
		{
			counter ++;
		}
		
		if(counter == 4){
			RenderedImage img = browser.getPage().getSnapshot();
			Reporter.reportEvent("OverPayment Search ", "No value entered",Status.Failed, img);
			System.exit(1);
		}
		else
		{
		//Submit or Clear
		browser.describe(Button.class, oSubmitBtn).click();
		browser.sync();
		Thread.sleep(2000);
		//	browser.describe(Button.class, oClearBtn).click();
		}


	}

	public void fn_validate_SearchResult(String Scenario_flow) throws ReportException, GeneralLeanFtException
	{
		String Innertext = browser.describe(WebElement.class, new WebElementDescription.Builder()
				.className("leadstableholder ng-scope").tagName("DIV").innerText(new RegExpProperty(".*")).build()).getInnerText();
		//System.out.println(Innertext);
		if (Innertext.contains(" 0 in total"))
		{
			System.out.println("No Records Found");

			if(Scenario_flow.equalsIgnoreCase("Negative")){
				RenderedImage img = browser.getPage().getSnapshot();
				//Reporter.reportEvent("OverPayment Search Result", "No Results found",Status.Passed, img);
			}
			else
			{
				RenderedImage img = browser.getPage().getSnapshot();
				//Reporter.reportEvent("OverPayment Search Result", "No Results found",Status.Failed, img);

			}
		}
		else
		{
			System.out.println(" Records Found");
			if(Scenario_flow.equalsIgnoreCase("Positive")){
				RenderedImage img = browser.getPage().getSnapshot();
		//		Reporter.reportEvent("OverPayment Search Result", "Results found",Status.Passed, img);
			}
			else
			{
				RenderedImage img = browser.getPage().getSnapshot();
				Reporter.reportEvent("OverPayment Search Result", "Results found",Status.Failed, img);

			}
		}

	}
}
