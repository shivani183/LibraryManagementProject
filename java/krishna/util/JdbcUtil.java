package krishna.util;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		return physicalConnection();
	}

	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "/Users/avinashsingh/eclipse-workspace_2022/AAALibraryManagementProject/src/main/java/properties/application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		properties.load(fis);

		String url = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}

}
