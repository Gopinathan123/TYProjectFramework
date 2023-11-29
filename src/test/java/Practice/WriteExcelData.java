package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//wb.getSheet("Sheet1").getRow(5).getCell(0).setCellValue("Rakoten");
		Sheet sht = wb.getSheet("Sheet1");
		sht.createRow(10).createCell(0).setCellValue("Rakoten");
		sht.getRow(10).createCell(1).setCellValue("Japan");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
