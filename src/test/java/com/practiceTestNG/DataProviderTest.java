package com.practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@DataProvider
	public Object[][] storeData()
	{
	Object[][] obj= new Object[4][2];

	obj[0][0]="BNG";
	obj[0][1]="MYR";

	obj[1][0]="MYR";
	obj[1][1]="HYD";

	obj[2][0]="MYR";
	obj[2][1]="PUN";

	obj[3][0]="CHN";
	obj[3][1]="HYD";
	return obj;
	}

	@Test (dataProvider ="storeData")
	public void getData(String from, String dst)
	{
	System.out.println("Travelling from "+from+" to "+dst);
	
	}
}
