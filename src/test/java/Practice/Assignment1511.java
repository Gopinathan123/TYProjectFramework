package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Assignment1511 {
public static void main(String[] args) throws SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Name:");
	String name=sc.nextLine();
	System.out.println("Enter the Age:");
	int age=sc.nextInt();
//	Random ran=new Random();
//	int random = ran.nextInt(19, 75);
	//To register the Database
	try
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//Connect to the database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
	
	//create statement
	Statement state = con.createStatement();
	String Query = "Insert into employee values('"+name+"',"+age+");";
	int result = state.executeUpdate(Query);
	System.out.println(result);
	String query1 = "Select * from employee";
	ResultSet result1 = state.executeQuery(query1);
	System.out.println(result1);
	
	}
	catch (Exception e) {
		boolean flag = false;
		if(name.equalsIgnoreCase(name))
		{
			System.out.println(" Is alreay present");
			flag=true;
		}
		else
		{
			
		}
	}
	finally
	{
		
		sc.close();
	}
}
}
