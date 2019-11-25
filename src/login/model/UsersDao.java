package login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import login.db.Users;

public class UsersDao {

	public static int doRegister(Users u) {
		// TODO Auto-generated method stub
		int status = 0;
		
		try 
		{
			
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "insert into Users values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPhone());
			pst.setString(5, u.getRegdno());
			pst.setString(6, u.getCollege());
			
			status = pst.executeUpdate();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return status;
	}

	public static boolean doVallidate(Users ob) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		
		try 
		{
			
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "select * from Users where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ob.getEmail());
			pst.setString(2, ob.getPassword());
			
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				status=true;
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		return status;
	}

	public static String getPassword(Users ob) {
		// TODO Auto-generated method stub
		String password = null;
		try 
		{
			
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "select password from Users where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ob.getEmail());
		
			
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
			password = rs.getString(1);
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return password;
	}

	public static int doChangePassword(Users ob) {
		// TODO Auto-generated method stub
		int status = 0;
		try 
		{
			
			Connection con = login.db.Provider.getOracleConnection();
			
			String sql = "select email from Users where password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ob.getOpass());
		
			
			
			ResultSet rs = pst.executeQuery();
	
		 
		    
		    
			if(rs.next())
			{
			   if(ob.getCpass().equals(ob.getNpass()))
			   {
				   String sql2 = "update Users set password=? where password=?";
				   PreparedStatement pst2 = con.prepareStatement(sql2);
				   pst2.setString(1, ob.getNpass());
				   pst2.setString(2,ob.getOpass());
				   
				  status = pst2.executeUpdate();
			   }
			   else
			   {
				   status = -1;
			   }
			}
			else
			{
				status = -2;
			}
			
		}
		catch (Exception e)
		{
			status = -100;
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
	}

}
