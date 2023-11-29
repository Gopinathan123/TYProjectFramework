package dataProvide;

import org.testng.annotations.DataProvider;

public class OrgData {
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[2][3];
		obj[0][0]="BNG";
		obj[0][1]="MYR";
		obj[0][2]=2000;

		obj[1][0]="MYR";
		obj[1][1]="HYD";
		obj[1][2]=3500;

		return obj;
		
	}

}
