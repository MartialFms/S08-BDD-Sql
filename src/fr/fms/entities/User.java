package fr.fms.entities;

import java.sql.SQLException;
import java.util.Scanner;

import fr.fms.data.ArticleDao;
import fr.fms.data.UserDao;

public class User {
	private int id;
	private String login;
	private String password;
	private char type;

	public User(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, char type) {
		this.login = login;
		this.password = password;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getUserType() {
		return type;
	}

	public void setUserType(char type) {
		this.type = type;
	}
	
	public void createUser() {		System.out.println("Entrez son login");
	Scanner scan = new Scanner(System.in);
	while (!scan.hasNextLine())
		scan.next();
	String login = scan.nextLine();
	System.out.println("Entrez son mot de passe");
	while (!scan.hasNextLine())
		scan.next();
	String password = scan.nextLine();
	System.out.println("Entrez ses droits : \n[ Admin -> 'A' | User -> 'U' | Customer -> 'C' ] ");
	scan.next();
	char type = scan.next().charAt(0);

	User user = new User(login, password, type);
	UserDao userDao = new UserDao();
	try {
		userDao.create(user);
	} catch (SQLException e) {
		System.out.println("Utilisateur non créé.");
		
	}}
	
	public void deleteUser() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

}