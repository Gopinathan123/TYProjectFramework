package dataProvide;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.banking.bixi.GenericUtils.IPathConstants;

public class DataProviderExcelData {

	@DataProvider
	public Object[][] excelData() throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rowcount = sh.getLastRowNum();
		int cellcount = sh.getRow(0).getLastCellNum();
		 Object[][] obj = new Object[rowcount][cellcount];
		for(int i=0; i<rowcount;i++)
		{
			for(int j=0; j<cellcount;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		
		}
		return obj;
		
	}
}
