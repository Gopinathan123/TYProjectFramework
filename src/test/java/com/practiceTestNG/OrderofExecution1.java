package com.practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrderofExecution1 {
	@BeforeSuite
	public void Suit()
	{
		System.out.println("--Connect to DB--");
	}
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("--Open Browser --");
	}
	@BeforeMethod
	public void LoginApp()
	{
		System.out.println("--LoginAppl --");
	}
	@Test
	public void exeAppl()
	{
		System.out.println("--ExeAppl--");
	}
	@Test
	public void exeAppl1()
	{
		System.out.println("--ExeAppl1--");
	}
	@AfterMethod
	public void LogoutApp()
	{
		System.out.println("--LogoutAppl --");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("--Close Browser --");
	}
	@BeforeClass
	public void openBrowser1()
	{
		System.out.println("--Open1 Browser --");
	}
	@BeforeMethod
	public void LoginApp1()
	{
		System.out.println("--Login1Appl --");
	}
	
	@AfterMethod
	public void LogoutApp1()
	{
		System.out.println("--Logout1Appl --");
	}
	@BeforeMethod
	public void LoginApp2()
	{
		System.out.println("--Login2Appl --");
	}
	@AfterClass
	public void closeBrowser1()
	{
		System.out.println("--Close1 Browser --");
	}
	@AfterSuite
	public void Suitclose()
	{
		System.out.println("--DisConnect the DB--");
	}

}
