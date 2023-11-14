package FinanceAnalyzer.financeClasses;

public abstract class FinantialOperation {
  protected double amount;
  protected String name, date, category, description;

  public FinantialOperation(String name, double amount, String date, String category, String description) {
    this.name = name;
    this.amount = amount;
    this.date = date;
    this.category = category;
    this.description = description;
  }

  public double getAmount() {
    return this.amount;
  }

  public String getName() {
    return this.name;
  }

  public String getDate() {
    return this.date;
  }

  public String getCategory() {
    return this.category;
  }

  public String getDescription() {
    return this.description;
  }



  public static void main(String[] args) {
    // - - - 
    
  }
}
