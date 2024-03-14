package connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class mariadb_connection {
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			throw new SQLException("Driver JDBC do MariaDB não encontrado.", e);
		}
		
		return DriverManager.getConnection("jdbc:mariadb://localhost:3306/login", "root", "12345ab");
	}
}
