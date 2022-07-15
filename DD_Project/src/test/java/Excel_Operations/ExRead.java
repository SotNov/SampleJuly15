package Excel_Operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class ExRead {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File f = new File("C:\\Users\\user\\Desktop\\Selenium Batch Nov 25th\\Sample_Excel_Test_Data\\Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet s = workbook.getSheetAt(0);

		for (Row r : s) {
			for (Cell c : r) {
				System.out.println(c.getStringCellValue());
			}
		}

		Row r = s.getRow(1);
		Cell c = r.getCell(2);
		System.out.println(c);

	}

}
