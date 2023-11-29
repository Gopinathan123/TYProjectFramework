package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {
	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		int result=0;
		try
		{
		//Register the Database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get the connection for Database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
		
		//Create Statement
		Statement state=con.createStatement();
		String Query=" insert into student_info values(8, 'Maaran','CSE',8.61);";
		String Query1="select * from student_info;";
		
		//Execute update
		result=state.executeUpdate(Query);
		ResultSet result1 = state.executeQuery(Query1);
		}
		
		/*if(result==1)
		{
			System.out.println("Data Updated Successfully");
		}
		else
		{
			System.out.println("Not Updated");
		}}*/
		
		catch(Exception e)
		{
			
		}
		finally {
			//close database
			con.close();
		}
		
	}
}
