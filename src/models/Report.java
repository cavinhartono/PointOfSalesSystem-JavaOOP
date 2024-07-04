package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  public void printYesterday() {
    Date date = new Date();
    date.setTime(date.getTime() - 24 * 60 * 60 * 1000);

    List<Transaction> Yesterdays = Transactions.stream()
        .filter(transaction -> transaction.getDate().equals(
            new SimpleDateFormat("yyyy-MM-dd").format(date))) // Kemarin
        .collect(Collectors.toList());

    System.out.println("\n/== Laporan Kemarin /==");
    for (Transaction transaction : Yesterdays) {
      System.out.println(transaction);
    }
    System.out.println("/== Laporan Kemarin /==");
  }

  public void printToday() {
    List<Transaction> Todays = Transactions.stream()
        .filter(transaction -> transaction.getDate().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date())))
        .collect(Collectors.toList());

    System.out.println("\n/== Laporan Hari Ini /==");
    for (Transaction transaction : Todays) {
      System.out.println(transaction);
    }
    System.out.println("/== Laporan Hari Ini /==");
  }
}
