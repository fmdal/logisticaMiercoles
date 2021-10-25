package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName(PropertiesUtil.getPropertyDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
//			System.out.println(PropertiesUtil.getPropertyUrl() + "  " + PropertiesUtil.getPropertyUsername() + "  "
//					+ PropertiesUtil.getPropertyPassword());
			System.out.println(PropertiesUtil.getPropertyUrl() + "," + PropertiesUtil.getPropertyUsername() + ","
					+ PropertiesUtil.getPropertyPassword());
			connection = DriverManager.getConnection(PropertiesUtil.getPropertyUrl(),
					PropertiesUtil.getPropertyUsername(), PropertiesUtil.getPropertyPassword());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}
}
