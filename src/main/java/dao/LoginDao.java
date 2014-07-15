package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	static PreparedStatement preparedstatement;
	static Connection connection;

	public boolean Login(String email, String password) {
		connection = DBC.getConnection();
		String sql = "select * from user_info where email = ? and password = ?";
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
