package Functions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Readphrase{

/**
* @param args
*/
	static int x;
	static Readphrase rp = new Readphrase();
	
public static void MyReadPhrase() throws Exception {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dbpath = "src/Files/phrase.xls";

	Connection con = DriverManager
	.getConnection("jdbc:odbc:DRIVER={Microsoft Excel Driver (*.xls)};DBQ="	+ dbpath);

	Statement stmt = con.createStatement();
	
	x = rp.reader_line();
			
	ResultSet rs = stmt.executeQuery("SELECT english, german FROM phrasetable WHERE line = " + x + "");
	
	rp.writer_line();
	
	ResultSetMetaData rsmd = rs.getMetaData();
	int clmCnt = rsmd.getColumnCount();
	
	while (rs.next()) {
		for (int i = 1; i <= clmCnt; i++) {
			System.out.print(rs.getString(i));
			System.out.print("\n");
		}
	System.out.println();
	}
	
	x++;
	
	con.close();
	}

public void writer_line()
{
	BufferedWriter writer = null;
	x++;
	try {
		writer = new BufferedWriter(new FileWriter("src/Files/line.txt"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		writer.write(x);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public int reader_line()
{
	BufferedReader reader = null;
	int x = 0;
	
	try {
		reader = new BufferedReader(new FileReader("src/Files/line.txt"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		x = reader.read();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return x;
	
}

}