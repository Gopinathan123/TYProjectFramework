package bixi_IBRegisterModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IB_Register_RefershTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
				
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		WebElement IB = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		WebElement IB_Reg = driver.findElement(By.xpath("//li[text()='Register']"));
		Actions a=new Actions(driver);
		a.moveToElement(IB).perform();
		a.moveToElement(IB_Reg).click().perform();
		
	}
}
