package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadNextAvailValue {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int count = sh.getLastRowNum();
		String expData = "TestCase";
		for(int i=0;i<=count; i++)
		{
			Row row = sh.getRow(i);
			String fstColData = row.getCell(0).getStringCellValue();
			if(fstColData.equalsIgnoreCase(expData))
			{
				String sndColData = row.getCell(1).getStringCellValue();
				System.out.println("Available==>"+sndColData);
				break;
			}
			
		}
	}
}
