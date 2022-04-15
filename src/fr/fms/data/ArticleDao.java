package fr.fms.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public void create(Article article) throws SQLException {
		try {
			String query = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, article.getDescription());
			prepStat.setString(2, article.getBrand());
			prepStat.setDouble(3, article.getPrice());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull insert !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(Article article) throws SQLException {
		String query = "SELECT * FROM T_Articles WHERE IdArticle = ?";
		PreparedStatement prepStat = connection.prepareStatement(query);
		prepStat.setLong(1, article.getId());
		prepStat.executeUpdate();
	}

	@Override
	public void update(Article article) throws SQLException {
		try {
			String query = "UPDATE T_Articles SET Brand= ? WHERE Description= ?";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, article.getBrand());
			prepStat.setString(2, article.getDescription());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull update !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Article article) throws SQLException {
		try {
			String query = "DELETE IdArticle=? FROM T_Articles";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setInt(1, article.getId());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull delete !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Article> readAll() throws SQLException {
		String query = "SELECT * FROM T_Users";
		PreparedStatement prepStat = connection.prepareStatement(query);
		prepStat.executeUpdate();
		return null;
	}

}
