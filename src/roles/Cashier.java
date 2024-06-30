package roles;

import models.Inventory;
import models.Product;
import models.Report;
import models.Transaction;

public class Cashier extends User implements Action {
  public Cashier(String username, String password) {
    super(username, password, "Kasir");
  }

  @Override
  public void addProduct(Inventory inventory, String name, String productID, double price, int qty) {
    System.err.println("Tidak dapat diakses. (Kasir)");
  }

  @Override
  public void sellProduct(Inventory inventory, Report report, String productID, int qty) {
    Product product = inventory.searchProductByID(productID);
    if (product != null && product.isSellProduct(qty)) {
      double totalPrice = product.getPrice() * qty;
      Transaction transaction = new Transaction(productID, qty, totalPrice, getUsername());
      report.setTransaction(transaction);
      report.printStruct(transaction, product);
    } else {
      System.out.println("Produk tidak bersedia dikarenakan stok habis.");
    }
  }

  @Override
  public void upgradeProductInQty(Inventory inventory, String productID, int amount) {
    System.err.println("Tidak dapat diakses. (Kasir)");
  }
}
