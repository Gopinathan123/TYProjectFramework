package bixi_StaffModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;
import com.banking.bixi.POM.BixiHomePage;
import com.banking.bixi.POM.BixiStaffHomePage;
import com.banking.bixi.POM.BixiStaffLoginPage;

public class ApprovePendingUsingPOMTest {
	public static void main(String[] args) throws Throwable {

				FileUtils fLib=new FileUtils();
				WebDriverUtils wLib=new WebDriverUtils();
				
				String URL = fLib.readDataFromPropertyFile("url");
				String UserName = fLib.readDataFromPropertyFile("username");
				String Password = fLib.readDataFromPropertyFile("password");
			
				WebDriver driver=new ChromeDriver();
				wLib.maximizeWindow(driver);
				driver.get(URL);
				BixiHomePage bhp=new BixiHomePage(driver);
				bhp.click_StaffLogin();
				BixiStaffLoginPage bslp=new BixiStaffLoginPage(driver);
				bslp.Loginfunction(UserName, Password);
				BixiStaffHomePage bshp=new BixiStaffHomePage(driver);
				bshp.approvePendingCustClick();
				bshp.homeClick();
				bshp.logoutclick();
				driver.quit();
	}
}
