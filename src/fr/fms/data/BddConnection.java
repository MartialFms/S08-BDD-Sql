package fr.fms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

public class BddConnection {
	
	public static Connection getConnection(User user) {
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/shop";
		// ----

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong driver");
		}
		try {
			connection = DriverManager.getConnection(url, user.getLogin(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
