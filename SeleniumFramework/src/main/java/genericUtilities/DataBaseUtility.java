package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class DataBaseUtility implements IAutoConstantsUtility{
	Driver dbdriver;
	Connection connect;
	Statement statement ;
	ResultSet result ;
	/**
	 * This method has been developed to establish the connection between the selenium and sql database
	 */
	public void establishingConnection()
	{
		try {
			dbdriver=new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connect=DriverManager.getConnection(DB_URL,DB_UN,DB_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method has been developed to read data from databse
	 * @param query
	 * @param columnname
	 * @return the list of data that has been read
	 */
	public ArrayList readDataFromDatabase(String query,String columnname)
	{
		ArrayList data=new ArrayList();
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				data.add(result.getString(columnname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * This method has been developed to close the connection between seleium and databse
	 */
	public void closeConnection()
	{
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
