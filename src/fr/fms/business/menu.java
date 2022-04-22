package fr.fms.business;

import java.sql.SQLException;
import java.util.Scanner;

import fr.fms.entities.Article;

public class menu {
	public static Scanner scan = new Scanner(System.in);

	public static void userMenu(Article article) throws SQLException {

		System.out.println(
				"Que souhaitez vous faire ?\n[ 1 : Consulter tous les articles | 2 : Creer un article | 3 : Modifier un Article | 4 : Supprimer un article | 5 : Consulter un article seul ] ");

		while (scan.hasNextInt() == false)
			scan.next();

		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			article.readArticles();
			break;
		case 2:
			article.createArticle();
			break;
		case 3:
			Article.choiceArticle();
			article.updateArticle(article);
			break;
		case 4:
			article = Article.choiceArticle();
			article.deleteArticle(article);
			break;
		case 5:
			article = Article.choiceArticle();
			article.readArticle(article);
			break;
		default:
			System.out.println("Mauvaise saisie.");
			userMenu(article);
			break;
		}
		userMenu(article);
		System.out.println("\nSouhaitez vous continuer ? O/N\n");
		String tryAgain = scan.nextLine().toUpperCase();
		while (true) {
			if (tryAgain == "O") {
				userMenu(article);
			} else if (tryAgain == "N") {
				System.out.println("\nAu revoir");
			} else {
				System.out.println("C'est oui ou c'est non ?? Car oui tu met 'O', et non tu met 'N' !!!");
			}
		}

	}

	public static void customerMenu(Article article) throws SQLException {

		System.out.println(
				"Que souhaitez vous faire ?\n[ 1 : Consulter tous les articles | 2 : Voir le panier | 3 : Ajouter au panier | 4 : Supprimer du panier ] ");

		while (scan.hasNextInt() == false)
			scan.next();

		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			article.readArticles();
			break;
		case 2:
			article.showCart();
			article.updateArticle(article);
			break;
		case 3:
			article.addToCart();
			article.updateArticle(article);
			break;
		case 4:
			article.removeFromCart();
			article.deleteArticle(article);
			break;
		default:
			System.out.println("Mauvaise saisie.");
			customerMenu(article);
			break;
		}
		userMenu(article);
		System.out.println("\nSouhaitez vous continuer ? O/N\n");
		String tryAgain = scan.nextLine().toUpperCase();
		while (true) {
			if (tryAgain == "O") {
				customerMenu(article);
			} else if (tryAgain == "N") {
				System.out.println("\nAu revoir");
			} else {
				System.out.println("C'est oui ou c'est non ?? Car oui tu met 'O', et non tu met 'N' !!!");
			}
		}
	}
	
	public static void adminMenu(Article article) throws SQLException {

		System.out.println(
				"Que souhaitez vous faire ?\n[ 1 : Gerer les articles | 2 : Gerer les utilisateurs ] ");

		while (scan.hasNextInt() == false)
			scan.next();

		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			userMenu(article);
			break;
		case 2:
			System.out.println(
					"[ 1 : Ajouter un utilisateur | 2 : Supprimer un utilisateur ] ");
			switch (choice) {
			case 1:
				//createUser();
				break;
			case 2:
				//deleteUser();
				break;
			case 3:
				adminMenu(article);
				break;
			default:
				System.out.println("Mauvaise saisie.");
				adminMenu(article);
				break;
			}
			break;
		default:
			System.out.println("Mauvaise saisie.");
			adminMenu(article);
			break;
		}
		userMenu(article);
		System.out.println("\nSouhaitez vous continuer ? O/N\n");
		String tryAgain = scan.nextLine().toUpperCase();
		while (true) {
			if (tryAgain == "O") {
				userMenu(article);
			} else if (tryAgain == "N") {
				System.out.println("\nAu revoir");
			} else {
				System.out.println("C'est oui ou c'est non ?? Car oui tu met 'O', et non tu met 'N' !!!");
			}
		}

	}
}
