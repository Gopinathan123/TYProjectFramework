package bixi_StaffModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.JavaUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;

public class ApprovePendingAccountUseUtilTest {
	public static void main(String[] args) throws Throwable {
		
		//JavaUtils jLib=new JavaUtils();
		FileUtils fLib=new FileUtils();
		WebDriverUtils wLib=new WebDriverUtils();
		
		String Browser = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String UserName = fLib.readDataFromPropertyFile("username");
		String Password = fLib.readDataFromPropertyFile("password");
	
		
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		driver.findElement(By.xpath("//input[@name='home']")).click();
		driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
		driver.quit();
	}
		
}
