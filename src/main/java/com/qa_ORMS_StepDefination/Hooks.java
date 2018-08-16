/*package com.qa_ORMS_StepDefination;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Hooks {
public  static XSSFWorkbook workbook;

	@After
	public void Update_Status(Scenario scenario) throws Throwable {
		String excelFilePath = "C:/Workspace/leanft_ORMS_test_automation/src/main/java/com/qa_ORMS_DataManagement/ORMS_Test_Data_Sheet.xlsx";
		File f = null;
		// Reporting execution status in New relic
		try {
            FileInputStream file = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
 
        	for (int i = 1; i < sheet.getLastRowNum(); i++) {
        		Row currentRow = sheet.getRow(i);
        	        	System.out.println(sheet.getLastRowNum());	
        	        	System.out.println(scenario.getName());
        	        	
        		Cell ScenarioName = currentRow.getCell(0);
        		System.out.println(ScenarioName);
        		String sScenarioName = ScenarioName.toString();
        		if(scenario.getName().equalsIgnoreCase("Login Functionality of ORMS application"))
        		{
        			break;
        		}
        		if(sScenarioName.equalsIgnoreCase(scenario.getName()))
        		{
        			Cell SetStatus = currentRow.getCell(7);
        			SetStatus.setCellValue(scenario.getStatus());
        		}
        	}
        	
	
		FileOutputStream outputStream = new FileOutputStream("ORMS_Test_Data_Sheet.xlsx");
        workbook.write(outputStream);
        outputStream.close();
} catch (IOException | EncryptedDocumentException| InvalidFormatException ex) {
    ex.printStackTrace();
}




}
	}
*/