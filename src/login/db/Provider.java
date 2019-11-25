package login.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Provider {
	
	public static Connection getOracleConnection()
	{
		Connection con = null;
		try
		{ 
			Class.forName("oracle.jdbc.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lit");
					
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection getMysqlConnection()
	{
		Connection con = null;
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","litbbsr");
					
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args) {
		
		Connection con_ora = Provider.getOracleConnection();
		Connection con_mysql =Provider.getMysqlConnection();
		
		System.out.println(con_ora);
		System.out.println(con_mysql);
	}

}
