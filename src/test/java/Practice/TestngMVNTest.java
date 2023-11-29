package Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngMVNTest {
	
	@Test
	public void test1()
	{
		System.out.println("Sample execution");
	}
	@Test
	void test2()
	{
		Reporter.log("Sample Execution2", true);
	}
	

}
