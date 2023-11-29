package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MvnCmdParamTest {

	@Test
	public void cmdTest()
	{
		Object BROWSER = System.getProperty("Browser");
		String URL = System.getProperty("URL");
		String UserName = System.getProperty("UserName");
		String Password = System.getProperty("Password");
		
		
		//System.out.println(Browser);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		driver.quit();
		
				
	}
}
