// this app will be used to analyze the finances of a person
// it will be able to calculate the total amount of money spent
// it will be able to calculate the total amount of money earned
// it will be able to calculate the total amount of money saved
// it will be a console app that uses database
// it will be able to calculate the total amount of money spent on a particular item / service / category
package FinanceAnalyzer;
import java.util.Scanner;

import FinanceAnalyzer.financeClasses.Expence;

public class FinanceAnalyzer {
  public static void main(String [] args){ 
    // - - -
    Scanner input = new Scanner(System.in);
    String command;
    boolean exit = false;
    while (!exit) {
      System.out.println("Enter a command: (to see all commands possible, type \"help\"");
      command = input.nextLine();
      if (command.equals("help")) {
        System.out.println("Here are the commands you can use:\nadd expence\nadd income\nadd saving\nshow expences\nshow income\nshow savings\nshow statistics\nexit\n");
        // - - - 
      }
      if (command.equals("exit")) {
        exit = true;
      }
      if (command.equals("add expence")) {
        System.out.println("What did you buy? *: ");
        String name = input.nextLine();
        System.out.println("Enter the amount of money spent *: ");
        double amount = input.nextDouble();
        System.out.println("Enter the category of the expence: ");
        String category = input.nextLine();
        System.out.println("Enter the date of the expence: (dd/mm/yyyy)");
        String date = input.nextLine();
        System.out.println("Enter the description of the expence: ");
        String description = input.nextLine();
        // - - - 
        Expence exp = new Expence(name, amount, date, category, description);
      }


    }
  }  
}
