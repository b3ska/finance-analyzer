/**
  * File: Expence.java
 * Author: Artem Kalmakov
 * Date: 11/18/2023
*/

package FinanceAnalyzer.financeClasses;
import FinanceAnalyzer.db.DbOperations;
public class Expence extends FinantialOperation {

  public Expence(String name, double amount, String date, String category, String description) {
    super(name, amount, date, category, description);
    
  }

  public void recordExpence(DbOperations dbconn) {
    dbconn.pushToDb("expence", this);
  }

  public static void main(String[] args) {
    // - - - 
    // add expence to sqllite database
    
  }
}
