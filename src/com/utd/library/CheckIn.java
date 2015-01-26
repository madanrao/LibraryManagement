package com.utd.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckIn {
	ResultSet rs;
	SQLData sql=new SQLData();
	private String loan_id;
	private String book_id;
	private String card_no;
	private String date_in;
	
	public CheckIn()
	{
		
	}
	public CheckIn(String a,String b,String c)
	{
		loan_id = a;
		book_id = b;
		card_no = c;
	}
	public String toString()
	{
		return loan_id+" - "+book_id+" - "+card_no;
	}
	public int setLoanedBookInfo(String a)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date_in=sdf.format(new Date()); 
		String query="update book_loans set date_in='"+date_in+"' where loan_id='"+a+"';";
		int n=sql.setInfo(query);
		return n;
		
		
	}
	public ResultSet getLoanedBookInfo(String a,String b,String c,String d)
	{
		
		String query = "select loan_id,book_id,x.card_no from book_loans x,borrower y where x.card_no=y.card_no AND date_in IS NULL AND x.book_id like '%"+a+"%' AND x.card_no like '%"+b+"%' AND y.Fname like '%"+c+"%' AND y.Lname like '%"+d+"%';";
		rs=sql.getInfo(query);
		
		return rs;
	}
}
