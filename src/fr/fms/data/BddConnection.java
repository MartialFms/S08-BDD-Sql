package fr.fms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.fms.entities.Article;


public class BddConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2022";
		// ----

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong driver");
		}
		try {
			connection = DriverManager.getConnection(url, login, password);
//			connection = DriverManager.getConnection(url, user.getLogin(), user.getPassword());     // ??
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static ArrayList<Article> extractData() {
		ArrayList<Article> articles = new ArrayList<Article>();
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();

			// Exécution de la requête
			ResultSet resultat = statement.executeQuery("SELECT Description, Brand, UnitaryPrice FROM T_articles;");

			// Récupération des données
			while (resultat.next()) {
				String description = resultat.getString("Description");
				String brand = resultat.getString("Brand");
				double unitaryPrice = resultat.getDouble("UnitaryPrice");

				Article article = new Article();
				article.setDescription(description);
				article.setBrand(brand);
				article.setPrice(unitaryPrice);

				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}

}
