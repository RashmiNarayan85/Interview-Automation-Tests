package com.intershop.saig.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
		public static long PAGE_LOAD_TIMEOUT = 100;
		public static long IMPLICIT_WAIT = 60;
		

		//test data
		public static String TESTDATA_SHEET_PATH="./src/main/java/com/intershop/saig/testdata/TestData.xlsx";
		
		static Workbook book;
		static Sheet sheet;
		
		public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
			FileInputStream file = null;
			BufferedInputStream bis = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
				// FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
				bis = new BufferedInputStream(file);
				
				} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				book = WorkbookFactory.create(bis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			
			return data;
				
		}
			
		
		/*
		  public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
			FileInputStream file = null;
			BufferedInputStream bis = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
				
				// FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
				

				bis = new BufferedInputStream(file);
				
				} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				book = WorkbookFactory.create(bis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			
			return data;
		 
		  }
		*/
	}
