package com.qa_ORMS_TestRunner;

	
import java.io.File;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.*;

import com.hp.lft.report.ReportException;
//import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.qa_ORMS_DataManagement.FileReaderManager;
import com.qa_ORMS_Utility.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.cucumber.listener.Reporter;
	

/*@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
retryCount = 3,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = false,
toPDF = false,
outputFolder = "target/ORMS")*/
	@CucumberOptions( features = "C:/Workspace/leanft_ORMS_test_automation/resources/featureFiles", tags ={ "@Login, @OverPayment,@Logout"} ,
	        glue = {"com.qa_ORMS_StepDefination"},
	        		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ORMS_Extentreport.html"
	        				,"html:target/cucumber-html-report",
	        		        "json:target/cucumber.json", 
	        		        "pretty:target/cucumber-pretty.txt",
	        		        "usage:target/cucumber-usage.json",
	        		        "junit:target/cucumber-results.xml"},     		
	        monochrome = true     
	        
	               )

	public class ORMS extends AbstractTestNGCucumberTests {
		public static Properties prop;
		BaseClass BS = new BaseClass();
		
		
		@BeforeClass
		public void setup()
		{
		//sdk initialization  
		   ModifiableSDKConfiguration config;
		
			try {
				config = new ModifiableSDKConfiguration();
			
		
	    config.setServerAddress(new URI("ws://localhost:5095"));
	    
			SDK.init(config);
		
	 //   Reporter.init();
			
		   
	 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@AfterClass
		public void TearDown() throws Exception
		{
		//close the browser
	BaseClass.browser.close();
Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		//Reporter.generateReport();

/*CucumberDetailedResults results = new CucumberDetailedResults();
results.setOutputDirectory("target/");
results.setOutputName("cucumber-results");
results.setSourceFile("C:/Workspace/leanft_ORMS_test_automation/target/cucumber.json");
results.execute();*/
SDK.cleanup();
	    
	
		}
	
		}

