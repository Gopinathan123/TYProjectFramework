package bixi_DebitCardModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Practice.ReadDataFromJsonTest;

public class ApplyDebitCard_SmokeTest 
{
	public static void main(String[] args) throws IOException 
	{
		Properties p = new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		p.load(fis);
		
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
//		String USERNAME = p.getProperty("username");
//		String PASSWORD = p.getProperty("password");
//		String APP_NO = p.getProperty("App_No");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		
	}
}
