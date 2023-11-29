package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAndImages {
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//span[text()='✕']")).click();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println(allLinks.size());
		
		List<WebElement> ActiveLinks=new ArrayList<WebElement>();
		
		for(int i=0; i<allLinks.size();i++)
		{
			if(allLinks.get(i).getAttribute("href")!=null && (!allLinks.get(i).getAttribute("href").contains("javascript")))
			{
				ActiveLinks.add(allLinks.get(i));
			}
			
		}
		System.out.println("Active Links and Images are: "+ActiveLinks.size());
		
		for(int j=0; j<ActiveLinks.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection) new URL(ActiveLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(ActiveLinks.get(j).getAttribute("href")+"===>"+response);
		}
		driver.quit();
		
	}
}
