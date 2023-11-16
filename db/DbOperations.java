package FinanceAnalyzer.db;

import FinanceAnalyzer.financeClasses.FinantialOperation;
import java.sql.*;

public class DbOperations {
   private Connection conn;
   private String dbPath = "/home/beska/Documents/Uni/JAVA/FinanceAnalyzer/db/";

   public DbOperations() {
      openDb();
      createTables();
   }
   
   public void openDb() {
      try {
         Class.forName("org.sqlite.JDBC");
         this.conn = DriverManager.getConnection("jdbc:sqlite:"+dbPath+"finances.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }

   public void closeDb() {
      try {
         this.conn.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Closed database successfully");
   }

   public void createTables() {
      try {
         Statement statement = this.conn.createStatement();
         statement.executeUpdate("create table if not exists expence (id integer primary key autoincrement, name text, amount real, date text, category text, description text)");
         statement.executeUpdate("create table if not exists income (id integer primary key autoincrement, name text, amount real, date text, category text, description text)");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }

   public void pushToDb(String table, FinantialOperation operation) {
      try {
         Statement statement = this.conn.createStatement();
         statement.executeUpdate("insert into " + table + " (name, amount, date, category, description) values ('" + operation.getName() + "', " + operation.getAmount() + ", '" + operation.getDate() + "', '" + operation.getCategory() + "', '" + operation.getDescription() + "')");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }

   }

   public String getTotal(String table) {
      String data = "";
      try {
         Statement statement = this.conn.createStatement();
         ResultSet rs = statement.executeQuery("select sum(amount) from " + table);
         while (rs.next()) {
            data += rs.getDouble("sum(amount)");
         }
         rs.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      return data;
   }

   public String getTable(String table) {
      String data = "";
      try {
         Statement statement = this.conn.createStatement();
         ResultSet rs = statement.executeQuery("select * from " + table);
         while (rs.next()) {
            data += "Name: " + rs.getString("name") + " Amt: " + rs.getDouble("amount") + " Date:" + rs.getString("date") + " Category:" + rs.getString("category") + " \n" + rs.getString("description") + "\n\n";
         }
         rs.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      return data;
   }

}