package FinanceAnalyzer;
import java.util.Scanner;

import FinanceAnalyzer.db.DbOperations;
import FinanceAnalyzer.financeClasses.Expence;
import FinanceAnalyzer.financeClasses.Income;

public class FinanceAnalyzer {
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
        System.out.println("\n\nHere are the commands you can use:\nadd expence\nadd income\nshow expences\nshow incomes\nshow statistics\nexit\n");
        // - - - 
      }
      if (command.equals("exit")) {
        exit = true;
      }
      if (command.equals("add expence")) {
        System.out.println("What did you buy? *: ");
        String name = input.nextLine();
        System.out.println("Enter the amount of money spent *: ");
        double amount = -input.nextDouble();
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
        double amount = input.nextDouble();
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
        System.out.println(dbconn.getTable("expence"));
      }
      if(command.equals("show incomes")) {
        System.out.println(dbconn.getTable("income"));
      }
      if (command.equals("show statistics")) {
        double incomeTotal = Double.parseDouble(dbconn.getTotal("income"));
        double expenceTotal = Double.parseDouble(dbconn.getTotal("expence"));
        System.out.println("Money spent: " + expenceTotal + "\nMoney earned: " + incomeTotal + "\nMoney saved: " + (incomeTotal - expenceTotal));
      }
    }
  }  
}
