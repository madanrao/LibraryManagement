package com.utd.library;

import java.sql.ResultSet;

public class Displayer {
	
	SQLData sql = new SQLData();
	ResultSet rs;

	public ResultSet showQuote()
	{
		double i = Math.random()*6 + 1;
		int id = (int) i;
		String query = "select * from quotes where id="+id+";";
		rs = sql.getInfo(query);
		return rs;
	}
}
