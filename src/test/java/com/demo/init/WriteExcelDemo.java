package com.demo.init;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import statements
public class WriteExcelDemo {
	public static void main(String[] args) throws IOException {

		/*BufferedReader br = new BufferedReader(new FileReader("Resource\\FileCount.txt"));
		int count = Integer.parseInt(br.readLine());
		System.out.println("===========" + count);
		br.close();*/
	/*	FileInputStream fsIP = new FileInputStream(
				new File("E:\\Projects\\Genix\\DET-TMO\\Workspace\\DET\\Resource\\TestCases2.xlsx")); */// Read
		
		FileInputStream fsIP = new FileInputStream(
				new File("Resource/Error_Report.xlsx"));// the
																							// spreadsheet
																										// that
																										// needs
																										// to
																										// be
																										// updated

		XSSFWorkbook wb = new XSSFWorkbook(fsIP); // Access the workbook

		XSSFSheet worksheet = wb.getSheetAt(0); // Access the worksheet, so that
												// we can update / modify it.
		
		//FileWriter fw = new FileWriter("Resource\\FileCount.txt");
		// BufferedWriter bw = new BufferedWriter(fw);
		Cell cell = null; // declare a Cell object
		

		//BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Row ="+worksheet.getLastRowNum());
		for (int i = 1; i <= worksheet.getLastRowNum(); i++) {
			//System.out.println(i);
			/*BufferedWriter bw = new BufferedWriter(new FileWriter("Resource\\FileCount.txt"));
			bw.write(String.valueOf(i));
			bw.close();*/
			cell = worksheet.getRow(i).getCell(1); // Access the second cell in
													// second row to update the
													// value
			
					
			String line = cell.getStringCellValue();
			// cell.setCellValue("Rule "+line);
			//System.out.println(line);
			// System.out.println(" -----" +
			// worksheet.getRow(i).getCell(1).getStringCellValue());

			// String line = "Gate 1 Rule 000-006: You are attempting to submit
			// data that contains invalid characters";
			// String pattern = "[\\d]*[-][\\d]*";

			// Create a Pattern object
			// Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			// Matcher m = r.matcher(line);
			/*
			 * if (m.find( )) { System.out.println("Found value: " + m.group(0)
			 * ); System.out.println("Found value: " + m.group(1) );
			 * System.out.println("Found value: " + m.group(2) );
			 * cell.setCellValue(m.group(0)); // Get current cell value value
			 * and overwrite the value }
			 */

			// System.out.println("=="+worksheet.getLastRowNum());

			XSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 15);
			// font.setFontName("IMPACT");
			font.setItalic(true);
			font.setColor(HSSFColor.ROYAL_BLUE.index);

			XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
			style.setFont(font);

			worksheet.getRow(i).getCell(0).setCellStyle(style);

			if (i == 0) {
				continue;
			}
			if (i == 25) {
				break;
			}

		}
		
		System.out.println("Found Data on row: "+findRow(worksheet,"000007"));
		fsIP.close(); // Close the InputStream

		FileOutputStream output_file = new FileOutputStream(
				new File("E:\\Projects\\Genix\\DET-TMO\\Workspace\\DET\\Resource\\TestCases_temp.xlsx")); // Open

		wb.write(output_file); // write changes

		output_file.close(); // close the stream

	}
	
	private static int findRow(XSSFSheet worksheet, String cellContent) {
	    for (Row row : worksheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
	                    return row.getRowNum();  
	                }
	            }
	        }
	    }               
	    return 0;
	}
}
