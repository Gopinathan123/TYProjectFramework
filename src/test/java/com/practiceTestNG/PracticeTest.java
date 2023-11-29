package com.practiceTestNG;

import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.BaseClass;

import org.testng.Assert;
import org.testng.Reporter;
//@Listeners(com.banking.bixi.GenericUtils.ListenerImplementation.class)
public class PracticeTest extends BaseClass{
	@Test
	public void practtest1() {
		Reporter.log("--Practice Test1--", true);
	}
	@Test
	public void practtest2() {
		Assert.fail();
		Reporter.log("--Practice Test2--", true);
	}
}
