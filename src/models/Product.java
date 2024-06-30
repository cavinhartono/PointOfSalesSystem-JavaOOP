package models;

public class Product {
  private String name, productID;
  private double price;
  private int qty;

  public Product(String name, String productID, double price, int qty) {
    this.name = name;
    this.productID = productID;
    this.price = price;
    this.qty = qty;
  }

  public String getName() {
    return name;
  }

  public String getProductID() {
    return productID;
  }

  public double getPrice() {
    return price;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int amount) {
    this.qty += amount;
  }

  public boolean isSellProduct(int amount) {
    if (qty >= amount) {
      qty -= amount;
      return true;
    }

    return false;
  }
}
