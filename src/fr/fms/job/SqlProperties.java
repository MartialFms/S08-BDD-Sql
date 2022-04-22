package fr.fms.job;

import java.io.*;
import java.util.*;
public class SqlProperties {
   public static void main(String args[]) throws IOException {
      Properties prop = readPropertiesFile("credentials.properties");
      System.out.println("username: "+ prop.getProperty("user"));
      System.out.println("password: "+ prop.getProperty("pwd"));
   }
   public static Properties readPropertiesFile(String fileName){
      FileInputStream fileInput = null;
      Properties prop = null;
      try {
         fileInput = new FileInputStream(fileName);
         prop = new Properties();
         prop.load(fileInput);
      } catch(Exception e) {
      } 
      return prop;
   }
}