-------------------------------------------------------------------------------------------
-- - Reconstruction de la base de données 												---
-------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

-------------------------------------------------------------------------------------------
-- - Construction de la table des articles en vente										---
-------------------------------------------------------------------------------------------
CREATE TABLE T_Articles (
    IdArticle 			int(4) PRIMARY KEY AUTO_INCREMENT,
    Description 		varchar(30) NOT NULL,
    Brand 				varchar(30) NOT NULL,
    UnitaryPrice 		float(8) NOT NULL DEFAULT 0
) ENGINE = InnoDB;
	
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Souris', 'Logitoch', 65); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clavier', 'Microhard', 49.5); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Système d''exploitation', 'Fenetres Vistouille', 100); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Tapis souris', 'Chapeau bleu', 5); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clé USB 8 To', 'Syno', 65); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Laptop', 'PH', 1199); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('CD x 500', 'CETME', 250); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD-R x 100', 'CETME', 99); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD+R x 100', 'Logitech', 105); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Batterie Laptop', 'PH', 80); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Casque Audio', 'Syno', 105); 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Webcam', 'Logitoch', 755); 

SELECT * FROM T_Articles;

/*
  *** 1.1 ***
source Shop.sql;
  *** 1.2 ***
show databases;
  *** 1.3 ***
describe T_Articles;
  *** 1.4 ***
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Imprimante', 'Logitruc', 180);
select * from t_articles 
  *** 1.5 ***
UPDATE T_Articles SET Brand='Logimachin' WHERE Description='Imprimante';
select * from t_articles 
  *** 1.6 ***
DELETE IdArticle=13 FROM T_ARTICLES;
select * from t_articles 
  *** 1.7 ***
select * from t_articles where Unitaryprice>100;
  *** 1.8 ***
select * from t_articles where Unitaryprice>50 && Unitaryprice<150 ;
  *** 1.9 ***
select * from t_articles ORDER BY Unitaryprice;
  *** 1.10 ***
select Description from t_articles;
  *** 1.11 ***
select Brand from t_articles WHERE Unitaryprice>200 ORDER BY UnitaryPrice DESC;		>> ca affiche que Brand en se basant sur des données non visibles au rendu (le prix), par ordre decroissant
  *** 1.12 ***
CREATE TABLE T_CatName (T_CatName varchar(30) PRIMARY KEY );
ALTER TABLE T_Articles ADD COLUMN CatName varchar(30);
ALTER TABLE T_Articles ADD FOREIGN KEY(CatName) REFERENCES T_CatName(CatName);
select * from t_articles ORDER BY Unitaryprice;
describe T_CatName;
INSERT INTO T_CatName (CatName) VALUES ('PC');					>> etc...
update t_articles set T_Catname=3 where IdArticle=12;
  *** 1.13 ***
select * from T_articles where UnitaryPrice<100 OR UnitaryPrice = 5 order by UnitaryPrice;
 */

-------------------------------------------------------------------------------------------
-- - Construction de la table des utilisateurs									---
-------------------------------------------------------------------------------------------

CREATE TABLE T_Users (
	IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
	Login varchar(20) NOT NULL,
	Password varchar(20) NOT NULL,
    AdminRight 			boolean NOT NULL DEFAULT FALSE
) ENGINE = InnoDB;

INSERT INTO T_Users (Login, Password, AdminRight) VALUES ('root', 'fms2022', TRUE); 
INSERT INTO T_Users (Login, Password, AdminRight) VALUES ('mars', 'der1979', FALSE); 

SELECT * FROM T_Users;

