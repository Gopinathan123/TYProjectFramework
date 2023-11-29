package bixi_IBRegisterModule;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IB_Regisiter_SmokeTest {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException 
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
		WebElement IB = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		WebElement IB_Reg = driver.findElement(By.xpath("//li[text()='Register']"));
		// Mouse Hover to the Register button
		Actions a=new Actions(driver);
		a.moveToElement(IB).perform();
		a.contextClick(IB_Reg).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_T);
		Thread.sleep(6000);
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.quit();
	}
}
