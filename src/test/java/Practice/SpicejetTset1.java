package Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SpicejetTset1 {
			public static void main(String[] args) throws InterruptedException {

			// Handling Notification Popup
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			Thread.sleep(2000);

			// OPening Browser
			WebDriver driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.spicejet.com/");

			// Taking Departure date
			String month = "November";
			String year = "2023";
			String date = "18";
			String adult = "3";

			Actions a = new Actions(driver);

			// Clicking src and sending keys
			driver.findElement(By.xpath("//div[.='From']")).click();
			WebElement src = driver.findElement(By.xpath("//div[.='From']/div/input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']"));
			src.sendKeys("Beng");

			Thread.sleep(2000);

			// Selecting Destination
			WebElement dest = driver.findElement(By.xpath("//div[text()='To']/../div[2]/input"));
			a.click(dest).sendKeys("Del").perform();

			// selecting Departuredate
			driver.findElement(By.xpath("//div[text()='" + month + " ']/../..//div[text()='" + date + "']")).click();

			// Clicking Passengers Dropdown
			driver.findElement(By.xpath("//div[text()='Passengers']")).click();
			Thread.sleep(2000);

			// Selecting adult
			WebElement adultPlusBtn = driver
					.findElement(By.xpath("//div[text()='Adult']/../..//div[@data-testid='Adult-testID-plus-one-cta']"));

			for (;;) {
				try {
					driver.findElement(By.xpath("//div[text()='Adult']/../..//div[text()='" + adult + "']"));
					break;
				} catch (Exception e) {
					adultPlusBtn.click();

				}
			}

			// Closing Passengers Dropdown
			driver.findElement(By.xpath("//div[text()='Passengers']")).click();
			Thread.sleep(2000);

			// Clicking Search flight
			WebElement searchFlightBtn = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
			searchFlightBtn.click();

		}

	}
