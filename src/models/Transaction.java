package models;

public class Transaction {
  private String date, productID;
  private int qty;
  private double totalPrice;
  private String cashierName;

  public Transaction(String date, String productID, int qty, double totalPrice, String cashierName) {
    this.date = date;
    this.productID = productID;
    this.qty = qty;
    this.totalPrice = totalPrice;
    this.cashierName = cashierName;
  }

  public String getDate() {
    return date;
  }

  public String getProductID() {
    return productID;
  }

  public int getQty() {
    return qty;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public String getCashierName() {
    return cashierName;
  }
}
