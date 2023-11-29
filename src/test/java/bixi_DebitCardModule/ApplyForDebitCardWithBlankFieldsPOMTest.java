package bixi_DebitCardModule;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.bixi.GenericUtils.ExcelFileUtils;
import com.banking.bixi.GenericUtils.FileUtils;
import com.banking.bixi.GenericUtils.WebDriverUtils;
import com.banking.bixi.POM.BixiDebitcardPage;
import com.banking.bixi.POM.BixiHomePage;

public class ApplyForDebitCardWithBlankFieldsPOMTest {
	public static void main(String[] args) throws Throwable 
	{
		FileUtils plib = new FileUtils();
		ExcelFileUtils elib = new ExcelFileUtils();
		WebDriverUtils wlib = new WebDriverUtils();
	
		String URL = plib.readDataFromPropertyFile("url");
	
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String NAME = elib.readTheDataFromExcel("debitcard", 1, 1);
		String PAN = elib.readTheDataFromExcel("debitcard", 2, 1);
		String MOB = elib.readTheDataFromExcel("debitcard", 3, 1);
		String ACCOUNTNO = elib.readTheDataFromExcel("debitcard", 4, 1);
	
		BixiHomePage home = new BixiHomePage(driver);
		home.ApplyDebitCardLink();
	
	BixiDebitcardPage debit = new BixiDebitcardPage(driver);
	debit.send_Detail(NAME, PAN, MOB, ACCOUNTNO);
	debit.click_submit();
	
	wlib.alertPopupWithText(driver);

	driver.quit();
	}
}
