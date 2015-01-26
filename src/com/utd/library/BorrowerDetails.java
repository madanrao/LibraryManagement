package com.utd.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowerDetails {
String card_no;
ResultSet rs;
SQLData sql=new SQLData();
	public int doesBorrowerExist(String a)
	{
	card_no = a;
	String query = "select * from borrower where card_no='"+card_no+"';";
	rs = sql.getInfo(query);
	try {
		if(rs.next())
			return 1;
		else
			return 0;
	} catch (SQLException e) {
		// TODO Auto-generatedt catch block
		e.printStackTrace();
		return -1;
	}
	}
	public boolean isDuplicate(String a,String b,String c)
	{
	String query = "select * from borrower where Fname='"+a+"' and Lname='"+b+"' and address='"+c+"';";
	rs = sql.getInfo(query);
	try {
		if(rs.next())
			return true;
		else
		return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}
	public int fetchCardNumber()
	{
		String query = "select max(card_no) from borrower;";
		rs = sql.getInfo(query);
		try {
			if(rs.next())
				return rs.getInt(1);
			else
				return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public int enterNewBorrower(String a,String b, String c,String d)
	{
		String insertQuery = "insert into borrower(Fname,Lname,Address,Phone) values('"+a+"','"+b+"','"+c+"','"+d+"');";
		int outcome = sql.setInfo(insertQuery);
		if(outcome==1)
		{
			String query = "select card_no from borrower where Fname='"+a+"' and Lname='"+b+"' and Address='"+c+"';";
			rs = sql.getInfo(query);
			try {
				if(rs.next())
					{
					int temp=rs.getInt("card_no");
					return temp;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}// end if after returning the card_no on success
		
		return 0;
	}
	
	}

