package com.practiceTestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.BaseClass;
import com.banking.bixi.POM.BixiHomePage;
import com.banking.bixi.POM.BixiStaffLoginPage;

//@Listeners(com.banking.bixi.GenericUtils.ListenerImplementation.class)
public class PracticeAssert extends BaseClass {
	@Test(retryAnalyzer=com.banking.bixi.GenericUtils.RetryImplementation.class)
	public void assertStringTest() {
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.click_StaffLogin();
		BixiStaffLoginPage bslp=new BixiStaffLoginPage(driver);
		bslp.stafftextverify("StaffLogin");
		bslp.Loginfunction("username", "password");
	}
	@Test//(retryAnalyzer=com.banking.bixi.GenericUtils.RetryImplementation.class)
	public void assertStringTest1() {
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.click_StaffLogin();
		BixiStaffLoginPage bslp=new BixiStaffLoginPage(driver);
		bslp.stafftextverify("Staff");
		bslp.Loginfunction("username", "password");
	}

}
