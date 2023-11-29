/**
  * File: FinanceAnalyzer.java
 * Author: Artem Kalmakov
 * Date: 11/18/2023
*/
package FinanceAnalyzer;
import java.util.Scanner;

import FinanceAnalyzer.db.DbOperations;
import FinanceAnalyzer.financeClasses.Expence;
import FinanceAnalyzer.financeClasses.Income;

public class FinanceAnalyzer {

  public static double getAmount(Scanner input) {
    try {
      return Double.parseDouble(input.nextLine());
    }
    catch(NumberFormatException e) {
      System.out.println("Invalid input. Please try again.");
      return getAmount(input);
    }
  }

  public static int getId(Scanner input) {
    try {
      return Integer.parseInt(input.nextLine());
    }
    catch(NumberFormatException e) {
      System.out.println("Invalid input. Please try again.");
      return getId(input);
    }
  }

  public static void printLines() {
    for (int i = 0; i < 5; i++) {
      System.out.println();
    }
  }
  
  public static void main(String [] args){ 
    // - - -
    Scanner input = new Scanner(System.in);
    DbOperations dbconn = new DbOperations();
    String command;
    boolean exit = false;
    System.out.println("\n\n\n\n\n\n\nWelcome to FinanceAnalyzer");
    while (!exit) {
      System.out.println("Enter a command: (to see all commands possible, type \"help\"");
      command = input.nextLine();
      if (command.equals("help")) {
        System.out.println("\n\nHere are the commands you can use:\nadd expence\nadd income\nshow expences\nshow incomes\statistics\ndel\nmonthly report\nexit\n");
        // - - - 
      }
      if (command.equals("exit")) {
        dbconn.closeDb();
        System.err.println("Exiting FinanceAnalyzer");
        exit = true;
      }
      if (command.equals("add expence")) {
        System.out.println("What did you buy? *: ");
        String name = input.nextLine();
        System.out.println("Enter the amount of money spent *: ");
        double amount = getAmount(input);
        System.out.println("Enter the category of the expence: ");
        String category = input.nextLine();
        System.out.println("Enter the date of the expence: (dd/mm/yyyy)");
        String date = input.nextLine();
        System.out.println("Enter the description of the expence: ");
        String description = input.nextLine();
        // - - - 
        Expence exp = new Expence(name, amount, date, category, description);
        exp.recordExpence(dbconn);
      }
      if (command.equals("add income")) {
        System.out.println("Type of income? *: ");
        String name = input.nextLine();
        System.out.println("Enter the amount of money earned *: ");
        double amount = getAmount(input);
        System.out.println("Enter the category of the income: ");
        String category = input.nextLine();
        System.out.println("Enter the date of the income: (dd/mm/yyyy)");
        String date = input.nextLine();
        System.out.println("Enter the description of the income: ");
        String description = input.nextLine();
        // - - - 
        Income inc = new Income(name, amount, date, category, description);
        inc.recordIncome(dbconn);
      }
      if (command.equals("show expences")) {
        printLines();
        System.out.println(dbconn.getTable("expence"));
      }
      if(command.equals("show incomes")) {
        printLines();
        System.out.println(dbconn.getTable("income"));
      }
      if (command.equals("statistics")) {
        double incomeTotal = Double.parseDouble(dbconn.getTotal("income"));
        double expenceTotal = Double.parseDouble(dbconn.getTotal("expence"));
        printLines();
        System.out.println("Money spent: " + expenceTotal + "\nMoney earned: " + incomeTotal + "\nMoney saved: " + (incomeTotal - expenceTotal));

      }
      if (command.equals("del")) {
        System.out.println("Enter the type of operation you want to delete (expence or income): )");
        String table = input.nextLine();
        System.out.println("Enter the id of the operation you want to delete: ");
        int id = getId(input);
        try {
          dbconn.deleteOperation(table, id);
        }
        catch(Exception e) {
          System.out.println("Something went wrong. Please try again.");
        }

      }
      if(command.equals("monthly report")) {
        System.out.println("Enter the month you want to see the report for: ");
        String month = input.nextLine();
        System.out.println("Enter the year you want to see the report for: ");
        String year = input.nextLine();
        printLines();
        try {
          System.out.println(dbconn.getMonthlyReport(month, year));
        } catch (Exception e) {
          System.out.println("Something went wrong. Please try again.");
        }
      }
    }
  }  
}
