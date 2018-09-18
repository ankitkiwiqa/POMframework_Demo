package com.demo.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class TestData {

	// public static String Approver_employe_code =
	// getApproverEmployeeCodeFromExcel();
	// public static String Approver_password = getApproverPasswordFromExcel();

	/*
	 * ===================================== SIGN UP
	 * ====================================================
	 */

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	static int hour1 = TestData.randBetween(7, 12); // Hours will be displayed
													// in between 9 to 22
	static int min = TestData.randBetween(0, 59);

	static int hour2 = TestData.randBetween(13, 20);

	public static String intime = hour1 + ":" + min;
	public static String outtime = hour2 + ":" + min;

	public static int diff = (((hour2) * 60) + min) - (((hour1) * 60) + min);

	public static String total_time = Integer.toString(diff);
	 
	public static Sheet TestSheet = null;
	public static Sheet ResultTestSheet = null;
	public static XSSFWorkbook workbook;
	public static XSSFWorkbook workbookdata;
	public static XSSFWorkbook Resultworkbook;
	
	public static Sheet getDataExcelSheet(int sheetIndex) {
		String dataFilePath = "Resource/Configuration.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {

			System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());

			FileInputStream inputStream = new FileInputStream(new File(fullpath));

			workbookdata = new XSSFWorkbook(inputStream);
			firstSheet = workbookdata.getSheetAt(sheetIndex);

			//workbook.close();
			//inputStream.close();

			//TestSheet = firstSheet;
		} catch (Exception e) {
			System.out.println("Main sheet: "+ e);
		}
		return firstSheet;
	}
	

	
	
	public static void WriteCandidateexcel1(String filename,int sheetNo, int rowNo, int columnNo, String value) {
		{
			String dataFilePath = "Resource/"+filename;
			String dataFilePath2 = "Resource";
			File datafile = new File(dataFilePath);
			String fullpath = datafile.getAbsolutePath();

			File datafile2 = new File(dataFilePath2);
			String fullpath2 = datafile2.getAbsolutePath();
			XSSFSheet firstSheet = null;
			try {

				System.out.println(
						"full path ::::" + datafile.getAbsolutePath() + " con :: " + datafile.getCanonicalPath());

				System.out.println(
						"full path ::::" + datafile2.getAbsolutePath() + " con :: " + datafile2.getCanonicalPath());

				FileInputStream inputStream = new FileInputStream(new File(fullpath));

				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				firstSheet = workbook.getSheetAt(sheetNo);

				// System.out.println("Row =
				// "+firstSheet.getRow(2).getCell(1).setCellValue(value));

				System.out.println("written Data :: " + value);
				try {
					firstSheet.getRow(rowNo).getCell(columnNo).setCellValue(value);

				} catch (Exception e) {
					// TODO: handle exception
					firstSheet.createRow(rowNo).createCell(columnNo).setCellValue(value);
				}

				

				inputStream.close();
				FileOutputStream fos = new FileOutputStream(new File(fullpath));
				workbook.write(fos);

				FileOutputStream fileOut = new FileOutputStream(fullpath2);
				workbook.write(fileOut);
				// workbook.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	
	public static String getURL() {

		return getDataExcelSheet(0).getRow(0).getCell(1).getStringCellValue();
	}
	

	/*public static String getRandomDate()
	    {
	        
	    	Calendar cal = Calendar.getInstance();

			cal.add(Calendar.DAY_OF_MONTH, 1);

			int fromday = cal.get(Calendar.DAY_OF_MONTH);
			int fromyear = cal.get(Calendar.YEAR);
			
			cal.add(Calendar.MONTH, 2);
			
			String day=String.valueOf(getDate(fromday));
			String month=TestData.getMonthD(cal.get(Calendar.MONTH));
			String year=String.valueOf(fromyear);
			
			return day+" "+month+" "+year;	
	    }
*/
	


	
	
}
