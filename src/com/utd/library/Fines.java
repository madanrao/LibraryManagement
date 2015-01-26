package com.utd.library;

import java.sql.ResultSet;

public class Fines {
SQLData sql = new SQLData();
ResultSet rs;

public ResultSet showFines()
{
	String query = "select b.card_no,sum(f.fine_amt) as Total_Fine,f.paid from fines f,book_loans b where f.loan_id = b.loan_id and f.paid=false group by b.card_no;";
	rs = sql.getInfo(query);
	return rs;
}

public int refreshFines()
{
	int n;
	int q=0;
	int max_fines=0;
	int max_loans=0;
	String query;
	try{
	 query = "select max(loan_id) from fines;";
	rs = sql.getInfo(query);
	if(rs.next())
		max_fines = rs.getInt(1);
	
	query = "select max(loan_id) from book_loans;";
	rs = sql.getInfo(query);
	if(rs.next())
		max_loans = rs.getInt(1);
	
	if(max_loans>max_fines)
	{
		int c = max_loans-max_fines;
		while(c>0)
		{
			max_fines++;
			query = "insert into fines(loan_id,paid) values("+max_fines+",false);";
			sql.setInfo(query);
			c--;
		}
	}
	}
	catch(Exception e)
	{
		return 0;
	}
	query = "update fines f inner join book_loans b on f.loan_id=b.loan_id set fine_amt = datediff(date_in,due_date)*0.25 where b.date_in IS NOT NULL and f.paid = false and datediff(date_in,due_date)*0.25>0;";
	n=sql.setInfo(query);
	if(n==1)
	{
	query = "update fines f inner join book_loans b on f.loan_id=b.loan_id set fine_amt = datediff(CURDATE(),due_date)*0.25 where b.date_in IS NULL and f.paid = false and datediff(CURDATE(),due_date)*0.25>0;";
	q=sql.setInfo(query);
	if(q==1)
	{
		//System.out.println("Ghus gaya");
		query = "update fines set paid=true where fine_amt IS NULL or fine_amt<=0;";
		q = sql.setInfo(query);
	}
	}
	return q;
}

public int updateFines(String a)
{
	String query="update fines set paid=true where loan_id in (select loan_id from book_loans where card_no='"+a+"' AND date_in IS NOT NULL);";
	
	return sql.setInfo(query);
	
}

public int updatePartialFines(String a,String b)
{
	String query ="update fines set paid=true where loan_id in (select loan_id from book_loans where card_no="+a+" AND loan_id="+b+" AND date_in IS NOT NULL);";
	return sql.setInfo(query);
}

public ResultSet searchFines(String a,String b)
{
	String query = "select * from (select f.loan_id,f.fine_amt,f.paid,b.card_no,c.fname,c.lname from fines f,book_loans b,borrower c where f.loan_id = b.loan_id and b.card_no=c.card_no and f.paid=false and b.date_in IS NOT NULL group by b.card_no,f.loan_id) as x where x.card_no='"+a+"' and x.Fname like '%"+b+"%' and x.Lname like '%"+b+"%';";
	rs = sql.getInfo(query);
	return rs;
}
}
