package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {
	public static Connection getConnection(){
		Connection connection = null;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection("jdbc:mysql://127.6.155.130:3306/mistakechasinggame", "admine4XARLk", "SDwzj3gbZCDm");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return connection;
	}
	public static void main(String[] args) {
		 System.out.println(getConnection());
	}
}
