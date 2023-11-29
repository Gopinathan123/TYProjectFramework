package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ranking_CheckSA {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String Countryname="South Africa";
		List<WebElement> c_names = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[2]"));
		boolean flag=false;
		for(WebElement webele: c_names )
		{
			String Countrynames = webele.getText();
			if(Countrynames.equals(Countryname))
			{
				System.out.println("is present");
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("not present");
		}
		driver.quit();
	}

}
