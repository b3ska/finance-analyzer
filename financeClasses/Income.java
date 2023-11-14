package FinanceAnalyzer.financeClasses;
import FinanceAnalyzer.db.DbOperations;
public class Income extends FinantialOperation{

  public Income(String name, double amount, String date, String category, String description) {
    super(name, amount, date, category, description);
  }

  public void recordIncome(DbOperations dbconn) {
    dbconn.pushToDb("income", this);
  }
  
  
}
