package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {
	public static void main(String[] args) throws Throwable {
		String expected = "YANTRARMG881";
		Connection con = null ;
		try {
		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver1.get("http://rmgtestingserver:8084/");
		driver1.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver1.findElement(By.xpath("//button[@type='submit']")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.findElement(By.xpath("//ul[@class='list-unstyled components']/descendant::a[text()='Projects']")).click();
		driver1.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver1.findElement(By.xpath("//input[@name='projectName']")).sendKeys("YANTRARMG8810");
		driver1.findElement(By.name("createdBy")).sendKeys("Deepak H R");
		WebElement selectele = driver1.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(selectele);
		s.selectByVisibleText("Created");
		driver1.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver1.quit();
		
		//Validating the data
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "Select * from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag =false;
		while (result.next()) {
			
			String actual = result.getString(4);
			
			if(actual.equalsIgnoreCase(expected))
			{
				flag=true;
				break;
			}
		}
		if(flag=true)
		{
			System.out.println("Project created Successfully");
		}
		else
		{
			System.out.println("Project Not created");
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		//close database
		con.close();
		}
	}
}
