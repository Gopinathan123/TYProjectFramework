package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabadiTest {

		public static void main(String[] args) {
			String team="Puneri Paltan";
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://www.prokabaddi.com/");
			driver.findElement(By.xpath("//span[text()='Standings']")).click();
			
			String position=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']/descendant::p[@class='position']")).getText();
			String matchPlayed=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data matches-play']/p")).getText();
			String matchWon=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data matches-won']/p")).getText();
			String matchLost=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data matches-lost']/p")).getText();
			String matchTie=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data matches-draw']/p")).getText();
			String scoreDiff=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data score-diff']/p")).getText();
			
			List<WebElement> allform = driver.findElements(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data form']//li/p"));
			
			
			String points=driver.findElement(By.xpath("//div[@class='table-body']/descendant::p[text()='"+team+"']/ancestor::div[@class='table-row-wrap']//div[@class='table-data points']/p")).getText();
			
			System.out.println("Team : "+team);
			System.out.println("Position : "+position);
			System.out.println("Match Played : "+matchPlayed);
			System.out.println("Match Won : "+matchWon);
			System.out.println("Match Lost : "+matchLost);
			System.out.println("Match Draw : "+matchTie);
			System.out.println("Score Diff : "+scoreDiff);
			for(WebElement form:allform )
			{
				String formResults=form.getText();
				System.out.print(formResults+" ");
			}
			System.out.println();
			System.out.println("Points : "+points);
			driver.quit();
		}

}
