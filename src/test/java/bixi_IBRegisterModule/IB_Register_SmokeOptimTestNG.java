package bixi_IBRegisterModule;


import org.testng.annotations.Test;

import com.banking.bixi.GenericUtils.BaseClass;
import com.banking.bixi.POM.BixiHomePage;

public class IB_Register_SmokeOptimTestNG extends BaseClass {
	@Test
	public void ibRegisterSmoke()
	{
		BixiHomePage bhp=new BixiHomePage(driver);
		bhp.clickOnregisterBtn(driver);
	}
}
