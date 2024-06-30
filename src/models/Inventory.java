package models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private List<Product> Products;

  public Inventory() {
    Products = new ArrayList<>();
  }

  public void setProduct(Product product) {
    Products.add(product);
  }

  public List<Product> getProducts() {
    return Products;
  }

  public Product searchProductByID(String productID) {
    for (Product product : Products) {
      if (product.getProductID().equals(productID)) {
        return product;
      }
    }
    return null;
  }
}
