package roles;

import models.Inventory;
import models.Product;
import models.Report;

public class Admin extends User implements Action {
  public Admin(String username, String password) {
    super(username, password, "Admin");
  }

  @Override
  public void addProduct(Inventory inventory, String name, String productID, double price, int qty) {
    inventory.setProduct(new Product(name, productID, price, qty));
  }

  @Override
  public void sellProduct(Inventory inventory, Report report, String productID, int qty) {
    System.err.println("Tidak dapat diakses. (Admin)");
  }

  @Override
  public void upgradeProductInQty(Inventory inventory, String productID, int amount) {
    Product product = inventory.searchProductByID(productID);
    if (product != null) {
      product.setQty(amount);
    }
  }
}
