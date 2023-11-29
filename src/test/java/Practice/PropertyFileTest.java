package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFileTest {
	public static void main(String[] args) throws IOException {
		
		//Create obj for property file
		Properties p=new Properties();
		p.setProperty("browser", "Chrome");
		p.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/");
		p.setProperty("username", "210001");
		p.setProperty("password", "password");
		
		//create obj for FOS
		FileOutputStream Fos = new FileOutputStream(".\\src\\test\\resources\\Commondata.properties");
		p.store(Fos, "Write Data");
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		p.load(fis);
		String Browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		System.out.println(Browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
		driver.quit();
		
		
		
		
	}

}
