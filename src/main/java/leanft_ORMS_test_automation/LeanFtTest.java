package leanft_ORMS_test_automation;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.qa_ORMS_DataManagement.ExcelReader;

import cucumber.api.java.en.When;

public class LeanFtTest{
	ExcelReader ER = new ExcelReader();
	static String SheetName = "ODAR_ID";
	
	



@When("^User makes a search with data present in ORMS excel sheet \"([^\"]*)\"$")
public void user_makes_a_search_with_data_present_in_ORMS_excel_sheet(String arg1) throws Throwable {
	   System.out.println("In function");
	   System.out.println(arg1);
    	    // Write code here that turns the phrase above into concrete actions
    		ER.ReadTestData(SheetName);
    		System.out.println("Outside excel function");
    	String eODARID = ExcelReader.hm1.get(arg1).get("ODAR_ID");
    	System.out.println(eODARID);
    }

}