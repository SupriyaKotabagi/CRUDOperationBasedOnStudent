package com.techpalle;

import java.sql.*;

public class A {
	
     Connection con =null;
     PreparedStatement ps = null;
     Statement s = null;
    
	public static String url = "jdbc:mysql://localhost:3306/jdbc";
	public static String username = "root";
	public static String password = "admin";
	
	public void creating() 
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url ,username, password);
			s = con.createStatement();
			
			s.executeUpdate("Create table emp(eid int primary key auto_increment,"
					+ "ename varchar(80) not null, esal int,email varchar(80) unique)");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//closing connections:
			try 
			{
				if(s != null)
				{
					s.close();
				}
				if(con != null)
				{
					con.close();
				}
			
			}

			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

	}
	public  void inserting(String name, int sal, String mail) 
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("insert into emp(ename, esal, email) values(?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//closing connections:
			try 
			{
				if(s != null)
				{
					s.close();
				}
				if(con != null)
				{
					con.close();
				}
			
			}

			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

	}   
	public  void updating(int id, String ename,int sal, String mail) 
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("update emp set ename=?, esal=?,email=? where eid=?");
			ps.setString(1, ename);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			ps.setInt(4, id);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//closing connections:
			try 
			{
				if(s != null)
				{
					s.close();
				}
				if(con != null)
				{
					con.close();
				}
			
			}

			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	} 
	public  void deleting(int id) 
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("delete from emp where eid=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//closing connections:
			try 
			{
				if(s != null)
				{
					s.close();
				}
				if(con != null)
				{
					con.close();
				}
			
			}

			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
     }   
}
           

