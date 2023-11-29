package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc_PosWithName {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> country = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[2]"));
		List<WebElement> positions = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		String[] con=new String[country.size()];
		String[] pos=new String[positions.size()];
		String[] mat=new String[matches.size()];
		
		for(int i=0;i<country.size();i++)
		{
			con[i] = country.get(i).getText();
			mat[i] = matches.get(i).getText();
			pos[i] = positions.get(i).getText();
		}
		for(int i=0;i<country.size();i++)
		{
			System.out.println(pos[i]+" "+con[i]+" "+mat[i]);
		}
		driver.quit();
	}
}
