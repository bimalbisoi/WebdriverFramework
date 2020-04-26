package com.test.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String testDatafilePath = "/Users/bimalendu/Documents/Learning/CoreJava/WebdriverFramework/src/main/resources/TestData.xlsx";
	public static FileInputStream inputExcel;
	public static FileOutputStream outputExcel;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;

	/**
	 * This method will return the data from the specified cell
	 *
	 * @param sheetName    the sheet name
	 * @param rowNumber    the row number
	 * @param columnNumber the column number
	 * @return the excel data
	 * @throws EncryptedDocumentException the encrypted document exception
	 * @throws IOException                Signals that an I/O exception has
	 *                                    occurred.
	 */
	public static String getExcelData(String sheetName, int rowNumber, int columnNumber)
			throws EncryptedDocumentException, IOException {
		try {
			inputExcel = new FileInputStream(testDatafilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook = WorkbookFactory.create(inputExcel);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		String celllvalue = row.getCell(columnNumber).getStringCellValue();
		return celllvalue;
	}

	/**
	 * This method will set the data to the specified cell
	 *
	 * @param sheetName    the sheet name
	 * @param rowNumber    the row number
	 * @param columnNumber the column number
	 * @param cellValue    the cell value
	 */
	public static void setExcelData(String sheetName, int rowNumber, int columnNumber, String cellValue) {
		try {
			inputExcel = new FileInputStream(testDatafilePath);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(inputExcel);
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.createCell(columnNumber);
		cell.setCellValue(cellValue);
		try {
			outputExcel = new FileOutputStream(testDatafilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(outputExcel);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
