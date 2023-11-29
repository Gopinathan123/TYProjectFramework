package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet("Sheet1");
		int rw = sht.getLastRowNum();
		int cell = sht.getRow(0).getLastCellNum();
		
		for(int i=0; i<=rw;i++)
		{
			for(int j=0; j<cell;j++)
			{
				String value = sht.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value);
				System.out.print("  ");
			}
			System.out.println();
		}
		
	}

}
