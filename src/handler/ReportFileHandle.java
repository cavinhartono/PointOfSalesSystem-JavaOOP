package handler;

import java.io.*;

import models.Report;
import models.Transaction;

public class ReportFileHandle {
  public static Report loadReports(String fileName) {
    Report report = new Report();
    try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = rd.readLine()) != null) {
        String[] Parts = line.split(",");

        if (Parts.length == 5) {
          String date = Parts[0];
          String productID = Parts[1];
          int qty = Integer.parseInt(Parts[2]);
          double totalPrice = Double.parseDouble(Parts[3]);
          String cashierName = Parts[4];

          report.setTransaction(new Transaction(date, productID, qty, totalPrice, cashierName));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return report;
  }

  public static void saveReports(Report report, String fileName) {
    try (BufferedWriter wr = new BufferedWriter(new FileWriter(fileName))) {
      for (Transaction transaction : report.getTransaction()) {
        wr.write(transaction.getDate() + "," + transaction.getProductID() + "," +
            transaction.getQty() + "," + transaction.getTotalPrice() + "," + transaction.getCashierName());
        wr.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}