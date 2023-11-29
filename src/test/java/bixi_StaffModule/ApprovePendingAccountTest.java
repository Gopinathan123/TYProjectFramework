package bixi_StaffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApprovePendingAccountTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='home']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
