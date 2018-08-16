package com.qa_ORMS_DataManagement;


import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

public static Properties prop;
	
	public Properties fn_ReadPropertyFile()
	{
	try {
		
     //reading from Property file
 	  
        prop = new Properties(); 
       FileInputStream ip = new FileInputStream("C:/Workspace/leanft_ORMS_test_automation/src/main/java/com/qa_ORMS_DataManagement/Config.Properties"); 
		prop.load(ip); 
		String URL = prop.getProperty("url");
		//System.out.println(URL);
		
       } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return prop;
}
	
	public String getReportConfigPath(){
		PropertyFileReader PR = new PropertyFileReader();
		String reportConfigPath = this.fn_ReadPropertyFile().getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
