package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SpiceJetTest {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notification");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='svg-img']//*[local-name()='g' and @fill='none']"));
		driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='svg-img'])[11]")).click();
		driver.findElement(By.xpath("//input[@autocapitalize=\"sentences\"]/ancestor::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/preceding-sibling::div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='MAA']")).click();
		driver.findElement(By.xpath("//div[text()='CJB']")).click();
		driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='svg-img']//*[local-name()='g' and @fill='none'])[3]")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='January ']/ancestor::div[@data-testid='undefined-month-January-2024']/descendant::div[text()='17']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='svg-img']//*[local-name()='g' and @fill='none'])[3]")).click();
			}
		}
		
	
		WebElement retdate = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/div[text()='Select Date']"));
		Actions a=new Actions(driver);
		a.moveToElement(retdate).perform();
		driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='svg-img']//*[local-name()='g' and @fill='none'])[3]")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='April ']/ancestor::div[@data-testid='undefined-month-April-2024']/descendant::div[text()='29']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='svg-img']//*[local-name()='g' and @fill='none'])[3]")).click();
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
