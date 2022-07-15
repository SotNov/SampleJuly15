package Excel_Operations;

import java.io.BufferedOutputStream;
import java.io.File;
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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExWr {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File F = new File("C:\\Users\\user\\Desktop\\Selenium Batch Nov 25th\\Sample_Excel_Test_Data\\Test_Data.xlsx");
		FileInputStream fid = new FileInputStream(F);
		XSSFWorkbook wb = new XSSFWorkbook(fid);
		XSSFSheet s = wb.getSheetAt(0);
		FileOutputStream fos = new FileOutputStream(F);

		for (Row r : s) {
			if (r.getRowNum() == 0) {
				continue;
			} else {
				int Cnum = r.getLastCellNum();
				String ss = "NewVlaue";
				Cell Ncell = r.createCell(Cnum);
				Ncell.setCellValue(ss + "  " + r.getRowNum());
				wb.write(fos);
			}
		}

		for (Row r : s) {
			for (Cell c : r) {
				String data = c.getStringCellValue();
				System.out.println(data);
			}
		}
		wb.close();
		fos.close();
		fid.close();
		
	}

}
