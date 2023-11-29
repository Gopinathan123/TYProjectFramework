package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphonePriceLessthen60000 {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			driver.findElement(By.name("field-keywords")).sendKeys("iphone", Keys.ENTER);
			List<WebElement> allIphoneName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			for (WebElement iphone : allIphoneName) {
				String iphoneName = iphone.getText();
				String iphonePrice = driver.findElement(By.xpath("//span[text()='" + iphoneName	+ "']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']")).getText();
				iphonePrice = iphonePrice.replace(",", "");
				int price = Integer.parseInt(iphonePrice);
				if ( price < 60000) {
					System.out.println("Name of product is : " + iphoneName + " and price is : " + iphonePrice);
				}
			}
			driver.quit();
		}
	}

