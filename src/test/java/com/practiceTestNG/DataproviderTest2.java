package com.practiceTestNG;

import org.testng.annotations.Test;

import dataProvide.OrgData;

public class DataproviderTest2 {
	@Test(dataProviderClass = OrgData.class, dataProvider = "data")
	public void exeData(String from, String dst, int price)
	{
		System.out.println("Travelling from "+from+" to "+dst+" price "+price);
	}

}
