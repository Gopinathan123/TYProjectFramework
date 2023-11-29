package com.banking.bixi.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	//Starting of test report
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"----TestScript Execution Start from here");
	}
	@Override
	//it will give the report of all the success test methods
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---PASSED---");
		Reporter.log(MethodName+"---Test Case Execution Successfull---");
	}
	@Override
	//it will give the report of all the failure test methods along with screenshot
	public void onTestFailure(ITestResult result) 
	{		
		String FS = result.getMethod().getMethodName();
		String FScript = FS+new JavaUtils().systemDateInFormat();
		test.addScreenCaptureFromPath(FScript);
		try {
			WebDriverUtils.getScreenShot(BaseClass.sdriver, FS);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, FScript+"---Failed---");
		Reporter.log(FScript+"---Test Case Execution Failed---");
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--Skipped--");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"---Test Case Execution Failed---");
	}
	@Override
	//Configuring the report
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreports/report.html");
		htmlreport.config().setDocumentTitle("Banking");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Bixi");	
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
		report.setSystemInfo("Reporter Name", "Gopinathan S");	
	}
	@Override
	public void onFinish(ITestContext context) 
	{
		//consolidate the report/ clean older report
		report.flush();
	}
	

}
