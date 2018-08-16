package com.qa_ORMS_TestPages;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.qa_ORMS_Utility.BaseClass;

public class LoginPage extends BaseClass {

	//Login page Objects
	public static EditFieldDescription oUsername  =new EditFieldDescription.Builder()
			.type("text").tagName("INPUT").name("USER").build();

	public static EditFieldDescription oPassword = new EditFieldDescription.Builder()
			.type("password").tagName("INPUT").name("PASSWORD").build();

	public static ButtonDescription oLoginButton =new ButtonDescription.Builder()
			.buttonType("button").tagName("INPUT").name("Login").build();
	
	

  //Page Actions
	public static void fn_NavigateToURL(String URL) throws GeneralLeanFtException
	{
		browser.navigate(URL);
		browser.sync();
	}

	public static void fn_ORMSLogin(String Username,String Password) throws GeneralLeanFtException, InterruptedException
	{
		browser.describe(EditField.class, oUsername).setValue(Username);

		browser.describe(EditField.class,oPassword ).setSecure(Password);  

		browser.describe(Button.class,oLoginButton ).click();
		browser.sync();
	Thread.sleep(1000);
	}



}
