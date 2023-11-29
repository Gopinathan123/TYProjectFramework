package bixi_DebitCardModule;


import org.testng.annotations.Test;
import com.banking.bixi.GenericUtils.BaseClass;
import com.banking.bixi.POM.BixiHomePage;

public class ApplyDebitCardSmokeOptim extends BaseClass {
	@Test
	public  void applyDebitCardSmokeOptim() throws Throwable 
	{
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.ApplyDebitCardLink();
		
	}

}
