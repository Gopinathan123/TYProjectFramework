package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	public static void main(String[] args) throws SQLException{
		
		//Register the driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//get Connection of Database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52", "root", "root");
		//Create Statement
		Statement state = conn.createStatement();
		String Query="select * from student_info;";
		//Execute Query
		ResultSet result=state.executeQuery(Query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getShort(4));
		}
		
	}
}
