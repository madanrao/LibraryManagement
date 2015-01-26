package com.utd.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
SQLData sql = new SQLData();
ResultSet rs;

public int insertUser(String a,String b)
{
	String query = "insert into login values('"+a+"','"+b+"');";
	
	return sql.setInfo(query);
}

public String fetchUserDetails(String a)
{
	String query = "select password from login where username='"+a+"';";
	rs = sql.getInfo(query);
	try {
		if(rs.next())
			return rs.getString("password");
		else
			return "Error";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "Exception";
	}
}
}
