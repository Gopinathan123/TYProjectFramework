package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicsMedalTest {
	public static void main(String[] args) {
		String countryname = "Australia";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		WebElement country = driver.findElement(By.xpath("//span[@data-cy='country-name' and text()='Australia']"));
		WebElement Gold = driver.findElement(By.xpath("//span[@data-cy='country-name' and text()='"+countryname+"']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@title='Gold']/descendant::span[@data-cy='medal-main']"));
		WebElement Silver = driver.findElement(By.xpath("//span[@data-cy='country-name' and text()='"+countryname+"']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@title='Silver']/descendant::span[@data-cy='medal-main']"));
		WebElement Bronze = driver.findElement(By.xpath("//span[@data-cy='country-name' and text()='"+countryname+"']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@title='Bronze']/descendant::span[@data-cy='medal-main']"));

		String con = country.getText();
		String gold = Gold.getText();
		String silver = Silver.getText();
		String bronze=Bronze.getText();
		System.out.println(con+" Gold: "+gold+" Silver: "+silver+" Bronze: "+bronze);
		driver.quit();
	}
	

}
