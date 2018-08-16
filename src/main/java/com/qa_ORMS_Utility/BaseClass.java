package com.qa_ORMS_Utility;


import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.qa_ORMS_DataManagement.PropertyFileReader;

public class BaseClass {
//public static Properties prop;
public static Browser browser;



public static void Launch_Browser() throws GeneralLeanFtException, ReportException 
{
	PropertyFileReader PR = new PropertyFileReader();

    String pBrowserName = PR.fn_ReadPropertyFile().getProperty("browser");
    System.out.println(PR.fn_ReadPropertyFile().getProperty("reportConfigPath"));
             
//	String BrowserName = "IE";
       if(pBrowserName.equalsIgnoreCase("IE"))
       {
             browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
        browser.fullScreen();
        Reporter.reportEvent("Browser Launched","Internet explorer browser",Status.Passed);
        
       }
       else if(pBrowserName.equalsIgnoreCase("chrome"))
       {
             browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.fullScreen();
  //      Reporter.reportEvent("Browser Launched","Chrome browser",Status.Passed);
       }
       else if(pBrowserName.equalsIgnoreCase("firefox"))
                    {
             browser = BrowserFactory.launch(BrowserType.FIREFOX);
        browser.fullScreen();
        Reporter.reportEvent("Browser Launched","Firefox browser",Status.Passed);
       
                    }
       else
       {
             //System.out.println("Invalid BrowserName, please check the name in config.property file");
             Reporter.reportEvent("browser Name incorrect", "Test Failed");
             
             
       }
       BaseClass.browser.clearCache();
       
}



		
}







