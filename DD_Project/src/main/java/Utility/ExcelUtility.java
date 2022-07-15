package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	// If the file is .xls then HSSFWorkbook
	// If the file is .xlsx then we can use XSSFWorkbook
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String XLFile, String XLSheet) throws IOException {
		// Get the row count
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;

	}

	// Get the cell count
	public static int getcellCount(String XLFile, String XLSheet, int rowNum) throws IOException {

		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum() - 1;
		wb.close();
		fis.close();
		return cellCount;

	}

	// To get the cell value
	public static String getCellData(String XLFile, String XLSheet, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		String data = null;
		DataFormatter formatter = new DataFormatter();

		try {

			data = formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "No data available";

		}
		wb.close();
		fis.close();
		return data;

	}

	// To write cell data to the excel file
	public static void setCellData(String XLFile, String XLSheet, int rowNum, int colNum, String data)
			throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(XLFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}

	// To delete cell
	public static void deleteCoulmnCell(String XLFile, String XLSheet) throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheetAt(0);
		Row row = ws.getRow(1);
		String data = null;
		DataFormatter formatter = new DataFormatter();
		for (Row r : ws) {
			if (r.getRowNum() == 0) {
				continue;
			}
			try {
				r.removeCell(r.getCell(2));
			} catch (Exception e) {
				data = "No data available";
			}

		}
		fos = new FileOutputStream(XLFile);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
	}

}
