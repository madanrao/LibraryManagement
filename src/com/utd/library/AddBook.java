package com.utd.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBook {
	ResultSet rs;
	int n;
	SQLData sql=new SQLData();
public int insertBookRow(String a, String b, String c, String d, String e, String f)
{
	String query;
	query = "select * from book b,book_authors a where b.book_id=a.book_id and a.book_id='"+a+"' and b.title='"+b+"' and a.author_name='"+c+"';";
	rs = sql.getInfo(query);
	try {
		if(rs.next())
		{
			query="update book_copies set no_of_copies = no_of_copies+"+f+" where book_id='"+a+"' and branch_id="+e+";";
			n = sql.setInfo(query);
			query = "select count(book_id) from book_copies where branch_id="+e+" and book_id='"+a+"';";
			rs = sql.getInfo(query);
			if(rs.next())
				if(rs.getInt(1)==0)
				{
				query = "insert into book_copies values('"+a+"',"+e+","+f+");";
				n = sql.setInfo(query);
				return 2;
				}
			return 0;
		}
		else
		{
			query = "select * from book where book_id='"+a+"';";
			rs = sql.getInfo(query);
			if(rs.next())
				return -1;
			
			if(a.length()<10)
			{
				for(int i=a.length();i<10;i++)
				{
					a = "0"+a;
				}
			}
		query="insert into book values('"+a+"','"+b+"');";
		n = sql.setInfo(query);
		if(n==1)
		{
			query = "insert into book_authors values('"+a+"','"+c+"',"+d+");";
			n = sql.setInfo(query);
			if(n==1)
			{
				query = "insert into book_copies values('"+a+"',"+e+","+f+");";
				n = sql.setInfo(query);
				if(n==1)
				{
					return n;// returns 1 to give a message that book added
				}
						
			}
		}
		
		
		
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	return -1;
	}
	return -1;

	
}
}