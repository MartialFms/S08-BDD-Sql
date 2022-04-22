package fr.fms.entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.business.menu;
import fr.fms.data.ArticleDao;
import fr.fms.data.BddConnection;
import fr.fms.job.TestJdbc;


public class Article {
private int id;
private String description;
private String brand;
private double price;

public Article(int id, String description, String brand, double price)
{
	this.id=id;
	this.description=description;
	this.brand=brand;
	this.price=price;
}

public Article(String description, String brand, double price)
{
	this.description=description;
	this.brand=brand;
	this.price=price;
}

public Article()
{
}

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getBrand() {
	return brand;
}


public void setBrand(String brand) {
	this.brand = brand;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public static Scanner scan = new Scanner(System.in);

public void createArticle() throws SQLException {
	System.out.println("Entrez la description de l'article :");
	while (!scan.hasNextLine()) scan.next();
	String description = scan.nextLine();	
	System.out.println("Entrez sa marque :");
	while (!scan.hasNextLine()) scan.next();
	String brand = scan.nextLine();	
	System.out.println("Entrez son prix unitaire :");
	while (!scan.hasNextDouble()) scan.next();
	double unityPrice = scan.nextDouble();
	
	Article article = new Article(description, brand, unityPrice);
	ArticleDao articleDao = new ArticleDao();
	articleDao.create(article);
}

public void readArticle(Article article) throws SQLException {
	choiceArticle();
	ArticleDao articleDao = new ArticleDao();
	System.out.println(">>>>>>>>>> " + article);						// temp
	articleDao.read(article);
	menu.userMenu(article);
}

public void updateArticle(Article article) {
	choiceArticle();
	System.out.println("Entrez sa nouvelle description :");
	while (!scan.hasNextLine()) scan.next();
	String description = scan.nextLine();	
	System.out.println("Entrez sa nouvelle marque :");
	while (!scan.hasNextLine()) scan.next();
	String brand = scan.nextLine();	
	System.out.println("Entrez son nouveau prix unitaire :");
	while (!scan.hasNextDouble()) scan.next();
	double unityPrice = scan.nextDouble();

	ArticleDao articleDao = new ArticleDao();
	articleDao.update(new Article(description, brand, unityPrice));
}

public void deleteArticle(Article article) throws SQLException {
	choiceArticle();
	ArticleDao articleDao = new ArticleDao();
	articleDao.delete(article);
}

public void readArticles() throws SQLException {
	ArticleDao articleDao = new ArticleDao();
	articleDao.readAll();
}

public static Article choiceArticle() {	
	ArrayList<Article> articles = BddConnection.extractData();
	System.out.println("Choisissez le numero d'article voulu :");
	for (int i = 1 ; i < articles.size(); i++) System.out.println(" [ " + i + " :  " + articles.get(i).getDescription() + " ("+ articles.get(i).getBrand() + ") ]");
	int articleRef = scan.nextInt();
	Article article = articles.get(articleRef);
	return article;
	}

public void showCart() {}
public void addToCart() {}
public void updateArticle() {}
public void removeFromCart() {}


@Override
public String toString() {
	return " [accountId=" + id + ", description=" + description + ", price=" + price + ", \n\t";
}
}