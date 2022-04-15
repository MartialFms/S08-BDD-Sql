package fr.fms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.fms.entities.Article;

public class BddConnection0 {

//	public static void bddConnect(String strSql) {
//		try (Connection connection = DriverManager.getConnection(userLogon.getDbUrl(), userLogon.getDbLogin(), userLogon.getDbPassword())) {						// commande sql
//			try (Statement statement = connection.createStatement()) {
//				try (ResultSet resultSet = statement.executeQuery(strSql)) {
//					while (resultSet.next()) {
//						int rsIdUser = resultSet.getInt(1);
//						String rsDescription = resultSet.getNString(2);
//						String rsBrand = resultSet.getNString(3);
//						double rsPrice = resultSet.getDouble(4);
//						articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
//					}
//				}
//			}
//			for (Article a : articles)
//				System.out
//						.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConnection() {
		try (Connection connection = DriverManager.getConnection(userLogon.getDbUrl(), userLogon.getDbLogin(), userLogon.getDbPassword())) {						// commande sql
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsDescription = resultSet.getNString(2);
					String rsBrand = resultSet.getNString(3);
					double rsPrice = resultSet.getDouble(4);
					articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
				}
			}
		}
		for (Article a : articles)
			System.out
					.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return connection;
	}
}
