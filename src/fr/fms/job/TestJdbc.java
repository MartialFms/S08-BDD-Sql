package fr.fms.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.data.BddConnection;
import fr.fms.data.Dao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TestJdbc {
	public static Scanner scan = new Scanner(System.in);
	public static User user;
	public static ArrayList<Article> articles = new ArrayList<Article>();

	public static void main(String[] args) throws Exception {
		
//		user = new User(1,"root", "fms2022");			// temp value
		
		userLogin(user);
		BddConnection.getConnection(user);				//methode de connection
		selectMenu();									// menu admin
		
	}
	public static void selectMenu() {

		System.out.println(
				"Que souhaitez vous faire ?\n[ 1 : Consulter tous les articles | 2 : Creer un article | 3 : Modifier un Article | 4 : Supprimer un article | 5 : Consulter un article seul ] ");

		while (!scan.hasNextInt())
			scan.next();
		int choice = scan.nextInt();

		switch (choice) {

		case 1:
			// readAll
			break;

		case 2:
			// create
			break;

		case 3:
			// update
			break;

		case 4:
			// delete
			break;

		case 5:
			// read
			break;
		default:
			selectMenu();
			break;
		}

	}
	
	public static void userLogin(User user) throws SQLException {
		System.out.println("Entrez votre login");
		String userLogin = scan.nextLine();
		
		System.out.println("Entrez votre mot de passe");
		String userPassword = scan.nextLine();
		
		String chkUser = "SELECT * FROM T_Users WHERE login = ? AND password = ?";
		PreparedStatement prepStat = Dao.connection.prepareStatement(chkUser);
		prepStat.setString(1, userLogin);
		prepStat.setString(2, userPassword);
		ResultSet result = prepStat.executeQuery();
		
		if (result != null) {
			System.out.println("Bienvenu");
		}
		else {
			System.out.println("Mauvais login/mot de passe");
			userLogin(user);
		}

	}
}
