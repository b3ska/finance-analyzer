package FinanceAnalyzer.financeClasses;

public class Expence extends FinantialOperation {

  public Expence(String name, double amount, String date, String category, String description) {
    this.name = name;
    this.amount = amount;
    this.date = date;
    this.category = category;
    this.description = description;
  }

  public static void main(String[] args) {
    // - - - 
    // add expence to sqllite database
    
  }
}
