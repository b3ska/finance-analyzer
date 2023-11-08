package FinanceAnalyzer.db;

import FinanceAnalyzer.financeClasses.FinantialOperation;
import java.sql.*;

public class DbOperations {
   private Connection conn;
   
   public void OpenDb() {
      try {
         Class.forName("org.sqlite.JDBC");
         this.conn = DriverManager.getConnection("jdbc:sqlite:finances.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }

   public void CloseDb() {
      try {
         this.conn.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Closed database successfully");
   }

   public void CreateTables() {
      try {
         Statement statement = this.conn.createStatement();
         statement.executeUpdate("create table expence if not exists (id integer primary key autoincrement, name text, amount real, date text, category text, description text)");
         statement.executeUpdate("create table income if not exists (id integer primary key autoincrement, name text, amount real, date text, category text, description text)");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }

   public void AddOperation(FinantialOperation operation, String type) {

   }

  public static void main( String args[] ) {
      DbOperations db = new DbOperations();
      db.OpenDb();
      db.CreateTables();
      db.CloseDb();
   }
}