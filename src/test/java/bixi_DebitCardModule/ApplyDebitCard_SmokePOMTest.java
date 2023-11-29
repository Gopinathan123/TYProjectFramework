package bixi_DebitCardModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.FileUtils;

import com.banking.bixi.GenericUtils.WebDriverUtils;
import com.banking.bixi.POM.BixiHomePage;

public class ApplyDebitCard_SmokePOMTest {
	public static void main(String[] args) throws Throwable 
	{
		FileUtils Flib=new FileUtils();
		WebDriverUtils wbLib=new WebDriverUtils();
		String URL = Flib.readDataFromPropertyFile("url");
				
		WebDriver driver=new ChromeDriver();
		wbLib.maximizeWindow(driver);
		
		driver.get(URL);
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.ApplyDebitCardLink();

		driver.quit();
		
	}

}
