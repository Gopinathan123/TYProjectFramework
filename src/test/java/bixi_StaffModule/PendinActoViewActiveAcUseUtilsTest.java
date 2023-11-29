package bixi_StaffModule;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;

public class PendinActoViewActiveAcUseUtilsTest {
	public static void main(String[] args) throws Throwable {
		
		FileUtils fLib=new FileUtils();	
		fLib.writeDataToPropertyFile("browser", "chrome");
		fLib.writeDataToPropertyFile("url", "http://rmgtestingserver/domain/Online_Banking_System/");
		fLib.writeDataToPropertyFile("username", "210001");
		fLib.writeDataToPropertyFile("password", "password");
		fLib.writeDataToPropertyFile("App_No", "password");
			
		//String Browser = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String UserName = fLib.readDataFromPropertyFile("username");
		String Password = fLib.readDataFromPropertyFile("password");
		String App_No = fLib.readDataFromPropertyFile("App_No");
			
		WebDriverUtils wLib=new WebDriverUtils();
		
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
		driver.findElement(By.xpath("//input[@name='application_no']")).sendKeys(App_No);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		//List<WebElement> cus_details_title = driver.findElements(By.xpath("//tbody/tr[1]/td"));
		List<WebElement> cus_details = driver.findElements(By.xpath("//tbody/tr[2]/td"));
		for(WebElement cus_detail: cus_details)
		{
			String text = cus_detail.getText();
			System.out.println(text);
			
		}
		driver.quit();
	
	}
}
