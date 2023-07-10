package com.numpyninja.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	List<Map<String, String>> excelData ;
	
	public ExcelReader(String sheetName, String excelFilePath) {
		try {
			readExcel(excelFilePath, sheetName);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readExcel(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		excelData =  readSheet(sheet);
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {

		Row row;
		Cell cell;

		int totalRow = sheet.getLastRowNum();

		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

			row = sheet.getRow(currentRow);

			int totalColumn = row.getLastCellNum();

			Map<String, String> columnMapdata = new HashMap<String, String>();

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

				cell = row.getCell(currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();

				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;
	}
	
	public String getGivenColumnFromExcel( int rowNumber, String colHeaderName) {
		
		return excelData.get(rowNumber).get(colHeaderName);
		
	}
	
	public Integer getRowCount() {
		return excelData.size();
	}

}
