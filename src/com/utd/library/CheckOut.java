package com.utd.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOut {
	int type;
	int loan_store;
	String branchName;
	String branchAddress;
	int cardno;
	String fname;
	String lname;
	String borrowerAddress;
	String phone;
	String date_out;
	String due_date;
	String date_in;
	ResultSet rs;
	SQLData sql=new SQLData();
	

public ResultSet lookUpBorrower(String a)
{
	cardno = Integer.parseInt(a);
	String query = "select count(*) as total_borrowed from book_loans where card_no = '"+cardno+"' and date_in IS NULL;";
	ResultSet rs = sql.getInfo(query);
	return rs;
}


public int insertNewBookLoan(String a,String b,String c)
{
	Calendar calendar=new GregorianCalendar();
	calendar.add(Calendar.DATE, 14);
	Date d=calendar.getTime();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	date_out=sdf.format(new Date());   //storing date_out in the sql format we require
    due_date=sdf.format(d);
   
    date_in=null;
	String q = new String();
	q="insert into book_loans(book_id,branch_id,card_no,date_out,due_date) values('"+a+"',"+b+",'"+c+"','"+date_out+"','"+due_date+"');";
    return sql.setInfo(q);
	
}
	
public int checkIfFines(String cardNo) 
{
	String query="select * from fines f,book_loans b where f.loan_id=b.loan_id and paid=false and fine_amt>0 and card_no='"+cardNo+"'";
	rs=sql.getInfo(query);
	try {
		if(rs.next())//if rows where fines not yet paid exist then dont check out
		{
			return 0;
		}
		else
		{
		return 1;	
		}
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 1;
}

	
}
