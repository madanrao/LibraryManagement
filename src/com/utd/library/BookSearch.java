package com.utd.library;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSearch {

	String bookid;
	String title;
	String authorName;
	int no_of_copies;
	int branchid;
	int remcopies;
	SQLData sql=new SQLData();
	
public BookSearch() {
		// TODO Auto-generated constructor stub
	}
public ResultSet searchResult(String a, String b, String c)
{
	bookid = a;
	title = b;
	authorName = c;
	
	//String query = "Select p.book_id,title,author_name,branch_id,no_of_copies from Book p,book_authors q,book_copies r where p.book_id = q.book_id AND p.book_id = r.book_id AND p.book_id like '%"+bookid+"%';";
	String query = "select book_id,title,author_name,branch_id,no_of_copies,remcopies from search where book_id like '%"+bookid+"%' and title like '%"+title+"%' and author_name like '%"+authorName+"%';";
	
	ResultSet rs = sql.getInfo(query);
	return rs;
}


}


	
