package com.banking.bixi.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection con=null;
	/**
	 * This method is used to create a connection for DataBase
	 * @author GopiNathan S
	 * @throws Throwable
	 */
	public void connectDB() throws Throwable
	{
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con = DriverManager.getConnection(IPathConstants.DBURl,IPathConstants.DB_Uname,IPathConstants.DB_Password);

	}
	/**
	 * This methods is used to execute and update the query 
	 * @param colData
	 * @param Expdata
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public String executeAndGetData(int colData, String Expdata, String query) throws Throwable {
		Statement state = con.createStatement();
		//String query = "select * from employee;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual = result.getString(colData);
			if(actual.equalsIgnoreCase(Expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Project Executed successfully");
			return Expdata;
		}
		else
		{
			System.out.println("Project is not created");
		}
		return "";
	}
	/**
	 * This method is used to close the Connection to the DataBase
	 * @author GopiNathan S
	 * @throws Throwable
	 */
	public void disconnectDB() throws Throwable {
		con.close();
	}
}
