package com.qa_ORMS_TestPages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.*;
import com.hp.lft.sdk.web.LinkDescription;
import com.qa_ORMS_Utility.BaseClass;

public class HomePage extends BaseClass {
 //Page objects
	LinkDescription	oMenuLink =new LinkDescription.Builder()
			.tagName("A").innerText("Menu").build();
	WebElementDescription oOverPayment = new WebElementDescription.Builder()
			.accessibilityName("").className("ng-scope").tagName("SPAN").innerText("Overpayment").index(0).build();
	LinkDescription oOverPaymentSearch =new LinkDescription.Builder()
			.role("").accessibilityName("").tagName("A").innerText("Search").index(0).build();
	LinkDescription	oHome =new LinkDescription.Builder()
			.tagName("A").innerText("Home ").build();
	LinkDescription	oLogout =new LinkDescription.Builder()
			.tagName("A").innerText("LOGOUT").build();
	
	//Page Actions
	public void fn_NavigateToORMSSearch() throws GeneralLeanFtException, InterruptedException
	{
		//Click on Menu Link
		browser.describe(Link.class,oMenuLink).click();
		browser.sync();
		Thread.sleep(2000);
	
		//Click on Overpayment
				browser.describe(WebElement.class,oOverPayment).click();
		browser.sync();
		
		//Click on Search
		browser.describe(Link.class,oOverPaymentSearch ).click();
		
		browser.sync();
		
		//Verify Title
	 String PageTitle = browser.getTitle();
	// System.out.println("overpayment title"+ PageTitle);
		
	
	}
	
	public void fn_NaviageToHomepage() throws GeneralLeanFtException{
		browser.describe(Link.class, oHome).click();
		browser.sync();
	}
	
public void fn_logout() throws GeneralLeanFtException{
	browser.describe(Link.class, oLogout).click();
	browser.sync();
}
}
