package bixi_StaffModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PendinActoviewActiveACTest {
	public static void main(String[] args) throws IOException, Throwable {
		Properties p=new Properties();
		p.setProperty("browser", "Chrome");
		p.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/");
		p.setProperty("username", "210001");
		p.setProperty("password", "password");
		p.setProperty("App_No", "281492836");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Commondata.properties");
		p.store(fos, "");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String APP_NO = p.getProperty("App_No");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(APP_NO);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		//List<WebElement> cus_details_title = driver.findElements(By.xpath("//tbody/tr[1]/td"));
		List<WebElement> cus_details = driver.findElements(By.xpath("//tbody/tr[2]/td"));
		for(WebElement cus_detail: cus_details)
		{
			String text = cus_detail.getText();
			System.out.println(text);
			
		}
		driver.findElement(By.name("approve_cust")).click();
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		//System.out.println("condion satisfied");
		 //to get only Digit value from the popup
		/*
		 String text = driver.switchTo().alert().getText();
		
		String accountNo = "";
		
		for(int i=0; i<=text.length(); i++)
		{
			if(Character.isDigit(text.charAt(i)))
			{
				String AcNo = accountNo+text.charAt(i);
				System.out.println(AcNo);
			}
		
		}*/
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("viewdet")).click();
		/*  To write the fetching data in the excel sheet
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sht = wb.getSheet("Sheet2");
		int count = sht.getLastRowNum();
		FileOutputStream fos1=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		for(int i=0;i<count;i++)
		{
			for(WebElement cus_detail_title:cus_details_title) {
			String text = cus_detail_title.getText();
			wb.write(fos1);
			sht.createRow(i).createCell(0).setCellValue(text);
			}
		}
		wb.close();*/
		
		//driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		
		//driver.quit();
		
		
		
		
		
		
	}

}
