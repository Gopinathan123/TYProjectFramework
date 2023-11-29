package com.banking.bixi.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelFileUtils {
	/**
	 * This method is used to fetch/read the data from excel
	 * @author GopiNathan S
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readTheDataFromExcel(String sheetName, int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * This Method is used to get the Total count of Row 
	 * @author GopiNathan S
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write the data into the  Excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writeTheDataIntoExcel(String sheetName, int row,int cell, String data) throws Throwable{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	
	public void readMultipleDataFromExcel(String sheetName, WebDriver driver) throws Throwable	{
		//JavaUtils jLib=new JavaUtils();
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<count;i++)
		{
			for(int j=0; j<count;j++)
			{
				String key = sh.getRow(i).getCell(j).getStringCellValue();
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
			}
		}
		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("accountname"))
			{
				//driver.findElement(By.name(sheetName));
			}
		}
		}
		
		public Object[][] excelData(String sheet) throws Throwable {
			FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
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
