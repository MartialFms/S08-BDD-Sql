package fr.fms.auth;

import java.sql.SQLException;
import java.util.Scanner;

import fr.fms.data.UserDao;
import fr.fms.entities.User;

public class auth {
	public static User userLogin() throws SQLException {	
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez votre login");
		String userLogin = scan.nextLine();
		System.out.println("Entrez votre mot de passe");
		String userPassword = scan.nextLine();
		UserDao userDao = new UserDao();
		userDao.checkLog(userLogin, userPassword);
		
		return new User(userLogin, userPassword);

	}
}
