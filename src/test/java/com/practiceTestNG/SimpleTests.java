package com.practiceTestNG;

import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.BaseClass;

import org.testng.Reporter;

public class SimpleTests extends BaseClass {
	@Test (groups={"Smoke","Regresion"})
	public void simpltest1() {
		Reporter.log("--Simple Test1--", true);
	}
	@Test (groups={"Smoke","Regresion"})
	public void simpltest2() {
		Reporter.log("--Simple Test2--", true);
	}
}
