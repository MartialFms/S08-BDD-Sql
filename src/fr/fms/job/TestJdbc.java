package fr.fms.job;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import fr.fms.auth.auth;
import fr.fms.business.menu;
import fr.fms.data.BddConnection;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TestJdbc {
	public static Scanner scan = new Scanner(System.in);
	public static User user; 
	public static Article article = new Article();
	public static Properties prop = SqlProperties.readPropertiesFile("credentials.properties");

	public static void main(String[] args) throws Exception {
		//auth.userLogin();			
		menu.userMenu(article);
		
	}
		
}
