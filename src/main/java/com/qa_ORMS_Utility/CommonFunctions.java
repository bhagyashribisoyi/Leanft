package com.qa_ORMS_Utility;



import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;

import com.hp.lft.report.CaptureLevel;
import com.hp.lft.report.ModifiableReportConfiguration;
import com.hp.lft.report.ReportConfigurationFactory;
import com.hp.lft.report.Reporter;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;

public class CommonFunctions extends BaseClass{

	public void Report() throws Exception{

        ModifiableReportConfiguration reportConfig = ReportConfigurationFactory.createDefaultReportConfiguration();
        reportConfig.setOverrideExisting(true);
        reportConfig.setTargetDirectory("C://Workspace//leanft_PHOW_test_autoamtion//RunResults"); // The folder must exist under C:\
        reportConfig.setReportFolder("myreportdirectory");
        reportConfig.setTitle("My Report Title");
        reportConfig.setDescription("Report Description");
        reportConfig.setSnapshotsLevel(CaptureLevel.All);

        Reporter.init(reportConfig);

}
}

