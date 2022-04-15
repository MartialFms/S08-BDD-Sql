package fr.fms.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

public class UserDao implements Dao<User> {

	@Override
	public void create(User user) throws SQLException {
		try {
			String query = "INSERT INTO T_Users (Login, Password) VALUES (?, ?)";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, user.getLogin());
			prepStat.setString(2, user.getPassword());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull insert !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void read(User user) throws SQLException {

			String query = "SELECT * FROM T_Users WHERE IdUser = ?";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setLong(1, user.getId());
			prepStat.executeUpdate();
		}
	
	@Override
	public void update(User user) throws SQLException {
		try {
			String query = "UPDATE T_Users SET Password= ? WHERE Login= ?"; 
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, user.getPassword());
			prepStat.setString(2, user.getLogin());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull update !");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(User user) throws SQLException {
		try {
			// String query = "DELETE IdUser=? FROM T_Users";
			String query = "DELETE FROM T_Users WHERE IdUser = ?";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, user.getLogin());
			if(prepStat.executeUpdate() ==1) System.out.println("Succefull delete !");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public ArrayList<User> readAll() throws SQLException {
		String query = "SELECT * FROM T_Users";
		PreparedStatement prepStat = connection.prepareStatement(query);
		prepStat.executeUpdate();
		return null;
	}
}
