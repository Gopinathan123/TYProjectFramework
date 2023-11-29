package com.practiceTestNG;

import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.BaseClass;

import org.testng.Reporter;

public class SampleTest extends BaseClass{
	@Test(groups="Regresion")
	public void sampletest1() {
		Reporter.log("--Sample Test1--", true);
	}
	@Test
	public void sampletest2() {
		Reporter.log("--Sample Test2--", true);
	}
}
