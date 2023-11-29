package bixi_IBLoginModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;
import com.banking.bixi.POM.BixiCusLoginPage;
import com.banking.bixi.POM.BixiHomePage;

public class IB_Login_ChangePasswordPOMTest {
	public static void main(String[] args) throws Throwable {
		
		
		FileUtils fLib=new FileUtils();
		String URL = fLib.readDataFromPropertyFile("url");
		String custID = fLib.readDataFromPropertyFile("cus_id");
		String cusPwd = fLib.readDataFromPropertyFile("cus_pwd");
		
		WebDriverUtils wLib=new WebDriverUtils();
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		wLib.maximizeWindow(driver);
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.IBLogin(driver);
		BixiCusLoginPage clp=new BixiCusLoginPage(driver);
		clp.CustomerLogin(custID, cusPwd);
		
		
		
				
		
	}
}
