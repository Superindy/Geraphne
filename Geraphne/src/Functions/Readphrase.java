package Functions;

import java.sql.*;

public class Readphrase{

/**
* @param args
*/
public static void main(String[] args) throws Exception {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dbpath = "/phrase.xls";

	Connection con = DriverManager
	.getConnection("jdbc:odbc:DRIVER={Microsoft Excel Driver (*.xls)};DBQ="	+ dbpath);

	Statement stmt = con.createStatement();
		
	int x = 1;

	ResultSet rs = stmt.executeQuery("SELECT english, german FROM phrasetable WHERE line = " + x + "");
	
	ResultSetMetaData rsmd = rs.getMetaData();
	int clmCnt = rsmd.getColumnCount();
	
	while (rs.next()) {
		for (int i = 1; i <= clmCnt; i++) {
			System.out.print(rs.getString(i));
			System.out.print("\n");
		}
	System.out.println();
	}
	
	con.close();
	}

}