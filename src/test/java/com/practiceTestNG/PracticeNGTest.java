package com.practiceTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeNGTest {
	
	@Test(priority = 0)
	public void createTest() {
		Reporter.log("----Created Successfully----",true);
	}
	
	@Test(priority = 1, dependsOnMethods = "createTest")
	public void deleteTest()
	{
		Reporter.log("----Deleted Successfully----",true);
	}
	
	@Test(dependsOnMethods = "modifyTest")
	public void editTest()
	{
		Reporter.log("----Edited Successfully----",true);
	}
	
	@Test(dependsOnMethods = "deleteTest", invocationCount =1 )
	public void modifyTest()
	
	{
		int []a= {1,2,3,4};
		System.out.println(a[5]);
		Reporter.log("----Modified Successfully----",true);
	}
}
