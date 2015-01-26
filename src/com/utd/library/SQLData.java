package com.utd.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLData {
String bookid;
String title;
String authorName;
int type;
String branchName;
String branchAddress;
int no_of_copies;
int branchid;
int cardno;
String fname;
String lname;
String borrowerAddress;
String phone;
String date_out;
String due_date;
String date_in;
static Connection conn = null;
int linect = 0;
ResultSet rs;
ResultSet getInfo(String query)
{try {
    // Create a connection to the local MySQL server, with the "company" database selected.
    //        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
    // Create a connection to the local MySQL server, with the NO database selected.
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");

    // Create a SQL statement object and execute the query.
    Statement stmt = conn.createStatement();

    // Set the current database, if not already set in the getConnection
    // Execute a SQL statement
    stmt.execute("use project;");

    // Execute a SQL query using SQL as a String object
    rs = stmt.executeQuery(query);

    System.out.println("Success!!");
} 
catch(SQLException ex) {
    System.out.println("Error in connection: " + ex.getMessage());
}

return rs;
}


int setInfo(String query)
{
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
		Statement stmt = conn.createStatement();
		stmt.execute("use project;");	
	    stmt.executeUpdate(query);
	    return 1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	
	
};
}