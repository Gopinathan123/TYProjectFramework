package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
		public static void main(String[] args) throws IOException {
			// Step 1. Launch The browser
			WebDriver driver = new ChromeDriver();

			// Step 2.Maximize the browser
			driver.manage().window().maximize();

			// enter url
			driver.get("https://www.amazon.in");

			java.util.List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

			ArrayList<String> al = new ArrayList<String>();

			URL url = null;
			int statusCode = 0;

			for (WebElement link : allLinks) {
				String hrefValue = link.getAttribute("href");
				try {
					url = new URL(hrefValue);
					HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
					statusCode = urlconn.getResponseCode();
					if (statusCode >= 400) {
						al.add(hrefValue);
						System.out.println(hrefValue + "----->" + statusCode);
					}

				} catch (MalformedURLException e) {
					if (statusCode >= 400)

						System.out.println(hrefValue + "----->" + statusCode);

				}
				
			}
			System.out.println("No of broken links are :"+al.size());
			
			for(String a:al) {
				System.out.println(a);
			}
			driver.quit();
		}

}
