package models;

import java.util.ArrayList;
import java.util.List;

public class Report {
  private List<Transaction> Transactions;

  public Report() {
    Transactions = new ArrayList<>();
  }

  public void setTransaction(Transaction transaction) {
    Transactions.add(transaction);
  }

  public List<Transaction> getTransaction() {
    return Transactions;
  }

  public void printStruct(Transaction transaction, Product product) {
    System.out.println("==/ Struk /==");
    System.out.println("-------------");
    System.out.println("Kasir: " + transaction.getCashierName());
    System.out.println(product.getName() + " x " + transaction.getQty() + " " + product.getPrice());
    System.out.println("Total: Rp. " + transaction.getTotalPrice());
    System.out.println("-------------");
    System.out.println("==/ Struk /==");
  }

  public void printReport() {
    System.out.println("==/ Sales Report /==");
    for (Transaction transaction : Transactions) {
      System.out.println(transaction);
    }
  }
}
