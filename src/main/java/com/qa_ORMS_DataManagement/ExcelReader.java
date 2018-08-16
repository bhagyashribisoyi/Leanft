package com.qa_ORMS_DataManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;


public class ExcelReader {
	static String TestDataPath = "C:/Workspace/leanft_ORMS_test_automation/src/main/java/com/qa_ORMS_DataManagement/ORMS_Test_Data_Sheet.xlsx";
public static HashMap<String, HashMap<String, String>> hm1 = new HashMap<>();
static String s3 = null;

	
	public void ReadTestData(String SheetName) throws IOException {

	FileInputStream file = new FileInputStream(TestDataPath);

	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(SheetName);
	Row HeaderRow = sheet.getRow(0);
	for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		Row currentRow = sheet.getRow(i);
		//System.out.println(sheet.getPhysicalNumberOfRows());
		HashMap<String, String> currentHash = new HashMap<String, String>();
		for (int j = 1; j < currentRow.getPhysicalNumberOfCells(); j++) {

			Cell currentCell1 = currentRow.getCell(1);
			//System.out.println(currentCell1);
			switch (currentCell1.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				s3 = currentCell1.getStringCellValue();
				//System.out.println(s3);
				break;
			case Cell.CELL_TYPE_NUMERIC:
				//s3 = String.valueOf(currentCell1.getNumericCellValue());
				s3 =new BigDecimal(currentCell1.getNumericCellValue()).toPlainString();
				//System.out.println(s3);
				break;
			}

			Cell currentCell = currentRow.getCell(j);
			//System.out.println(currentCell);
			switch (currentCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
						currentCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				//currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
					//	String.valueOf(currentCell.getNumericCellValue()));
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
						new BigDecimal(currentCell.getNumericCellValue()).toPlainString());
				break;
			}

		}
		
		hm1.put(s3, currentHash);
	}
}
}


	
	


