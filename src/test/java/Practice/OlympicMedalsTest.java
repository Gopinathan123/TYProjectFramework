package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicMedalsTest {
		public static void main(String[] args) {
			String country = "Armenia";
		
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://olympics.com/");
			driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
			driver.findElement(By.id("menu-olympic-games")).click();
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			
			for(;;)
			{
			try {
			j.executeScript("window.scrollBy(0,500)");
			WebElement tokyo2020 = driver.findElement(By.xpath("(//p[text()='Tokyo 2020'])[1]"));
			tokyo2020.click();
			break;
			}
			catch (Exception e) {
		
			}}

			for(;;)
			{
			try {
			j.executeScript("window.scrollBy(0,500)");
			WebElement medals = driver.findElement(By.xpath("//p[text()='See table']"));
			medals.click();
			break;
			}
			catch (Exception e) {
		
			}}
			


			String gold = driver.findElement(By.xpath("//span[text()='" + country + "']/../following-sibling::div[@title='Gold'][1]/span/span"))
					.getText();
			String silver = driver
					.findElement(By.xpath(
							"//span[text()='" + country + "']/../following-sibling::div[@title='Silver'][1]/span/span"))
					.getText();
			String bronze = driver
					.findElement(By.xpath(
							"//span[text()='" + country + "']/../following-sibling::div[@title='Bronze'][1]/span/span"))
					.getText();
			String totalMedals = driver.findElement(By.xpath(
					"//span[text()='Armenia']/../following-sibling::div[@data-medal-id='total-medals-row-2'][1]/span/span"))
					.getText();

			System.out.println("Country : " + country);
			System.out.println("Gold Medals in Tokyo Olympics 2020 : " + gold);
			System.out.println("Silver Medals in Tokyo Olympics 2020 : " + silver);
			System.out.println("Bronze Medals in Tokyo Olympics 2020 : " + bronze);
			System.out.println("Total Medals won in Tokyo Olympics 2020 are " + totalMedals);
		}
	}

