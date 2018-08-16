package com.qa_ORMS_Utility;



import org.testng.annotations.Test;

import com.github.mkolisnyk.cucumber.reporting.CucumberCoverageOverview;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.java.After;
	

public class XGenerateReportTest{

	/**
	* This function generates the report  - cucumber-results-test-results.html 
	* This gives the detailed information regarding the testcase execution status
	*/
@Test
	public void detailedReport()
	{
		CucumberDetailedResults results = new CucumberDetailedResults();
		System.out.println("executing report");
		
			results.setOutputDirectory("target/ORMS/");
			results.setOutputName("cucumber-detailedresults");
			results.setSourceFiles(new String[]{
					"json:cucumber.json"
			} ) ;
				try {
			results.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* This function generates the Overview report  - cucumber-Overviewresults-feature-overview.html
	* This gives the Overview charts and overview status of testcase execution status
	*/
@Test
	public void overviewReport()
	{
		CucumberResultsOverview results = new CucumberResultsOverview();
	
		System.out.println("executing report");
		results.setOutputDirectory("target/ORMS/");
		results.setOutputName("cucumber-Overviewresults");
		results.setSourceFiles(new String[]{
				"json:cucumber.json"
		} ) ;
		try {
			results.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

@Test
public void CoverageReport()
{
	CucumberCoverageOverview results = new CucumberCoverageOverview();
	System.out.println("executing report");
	results.setOutputDirectory("target/ORMS/");
	results.setOutputName("cucumber-Coverageresults");
/*	results.setSourceFiles(new String[]{
			"json:target/ORMS/cucumberreportOverpaymentSearch.json",
	} ) ;*/
	results.setSourceFiles(new String[]{
			"json:cucumber.json"
	} ) ;
	//results.setExcludeCoverageTags(new String[]{"@android"});
	//results.setIncludeCoverageTags(new String[]{"@ios"});
	try {
		results.execute();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
	



