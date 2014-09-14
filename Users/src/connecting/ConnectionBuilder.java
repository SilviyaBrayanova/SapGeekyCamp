package connecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {

	public static Connection buildConnection() {
		String username = "root";
		String password = "Poison6937";
		String url = "jdbc:mysql://localhost/users";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.err.println("Problem in connection");
				e.printStackTrace();
				 throw new IllegalStateException(e);
			}
		} catch (ClassNotFoundException ex) {
			System.err.println("Error loading driver");
			 throw new IllegalStateException(ex);
		}
	}
}
