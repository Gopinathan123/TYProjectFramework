package com.practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.ExcelFileUtils;

public class DataProviderTest3 {
//	@Test(dataProviderClass = DataProviderExcelData.class, dataProvider = "excelData")
//	public void exeData(String org, String loc )
//	{
//		System.out[.println("ORG-->"+org+"-->Loc-->"+loc);
//	}
	@DataProvider
	public Object[][] exeData( ) throws Throwable
	{
		ExcelFileUtils eLib=new ExcelFileUtils();
		Object[][] value = eLib.excelData("Sheet2");
		return value;
	}
	
	@Test(dataProvider = "exeData" )
	public void ExeExcelUtilData(String Org, String Loc)
	{
		System.out.println("Org-->"+Org+" Loc-->"+Loc);
	}
	
}
