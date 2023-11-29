package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzLivScore {
	public static void main(String[] args) {
		//String buzzpath = "//h2[contains(text(),'AUS')]";
		String country = "England";
		String buzzpath = "//span[@title='"+country+"']/ancestor::div[@class='cb-col-50 cb-ovr-flo cb-hmscg-tm-name']/following-sibling::div[@class='cb-col-50 cb-ovr-flo']";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebElement livescore = driver.findElement(By.xpath(buzzpath));
		System.out.println(country+" "+livescore.getText());
		driver.quit();
	}

}
