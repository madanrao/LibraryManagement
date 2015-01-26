package com.utd.library;

import java.sql.ResultSet;

public class BooksDue {
	SQLData sql=new SQLData();
	ResultSet rs;
public ResultSet dueDateThisWeek()
{
	String query="select a.book_id,a.branch_id,a.card_no,b.fname,b.lname from book_loans a,borrower b where a.card_no=b.card_no and  due_date between CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 14 day);";
	rs=sql.getInfo(query);
	return rs;
}



}
