package bixi_IBRegisterModule;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;

public class IB_Register_Smoke_UseingUtilsTest {
	public static void main(String[] args) throws Throwable 
	{
		
		FileUtils fLib=new FileUtils();
		
		String URL = fLib.readDataFromPropertyFile("url");
		
		WebDriverUtils wLib=new WebDriverUtils();
		
		
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		WebElement IB = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		WebElement IB_Reg = driver.findElement(By.xpath("//li[text()='Register']"));
		Actions a=new Actions(driver);
		a.moveToElement(IB).perform();
		a.contextClick(IB_Reg).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_T);
		Set<String> multiwindow = driver.getWindowHandles();
//		String Title = driver.getTitle();
//		System.out.println(Title);
		for(String singlewin:multiwindow)
		{
			String Title = driver.switchTo().window(singlewin).getTitle();
			System.out.println(Title);
		}
		Thread.sleep(6000);
		
		driver.quit();
	}

}
