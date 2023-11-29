package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ksrtc_Calender {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[contains(@value,'Date Of Departure')]")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='15']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
