package com.banking.bixi.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DataBaseUtils dLib=new DataBaseUtils();
	public FileUtils fLib=new FileUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	public WebDriver driver;
	
	//initialize the driver variable with sdriver variable to reinitialize it with static
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun= true)
	public void connect_DB() throws Throwable {
		dLib.connectDB();
		System.out.println("---DB Connected---");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun= true)
	//public void luanch_Browser(String BROWSER) throws Throwable
	public void luanch_Browser() throws Throwable
	{
	  String BROWSER = fLib.readDataFromPropertyFile("browser");
		 
	  if(BROWSER.equalsIgnoreCase("Chrome"))
		 {
			 driver=new ChromeDriver();
			 System.out.println("---Chrome Browser Opened---");
		 }
		 else if(BROWSER.equalsIgnoreCase("Firefox"))
		 {
			 driver=new FirefoxDriver();
			 System.out.println("---Firefox Browser Opened---");
		 }
		 else if(BROWSER.equalsIgnoreCase("Edge"))
		 {
			 driver=new EdgeDriver();
			 System.out.println("---Edge Browser Opened---");
		 }
		 else
		 {
			 System.out.println("---Invalid browser---");
		 }
		 
		 sdriver=driver;
		 
		 wLib.maximizeWindow(driver);
	}
	
	@BeforeMethod(alwaysRun= true)
	public void luanch_url() throws Throwable
	{
		String URL = fLib.readDataFromPropertyFile("url");
		wLib.implecitWait(driver, 15);
		driver.get(URL);
		System.out.println("---Entered URL---");
	}
	
	@AfterClass(alwaysRun= true)
	public void close_browser() {
		wLib.closebrowser(driver);
		System.out.println("---Browser Closed---");
	}
	
	@AfterSuite(alwaysRun= true)
	public void disconnect_DB() throws Throwable {
		dLib.disconnectDB();
		System.out.println("---DB Disconnected---");
	}
	

}
