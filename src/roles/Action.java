package roles;

import models.Inventory;
import models.Report;

public interface Action {
  void addProduct(Inventory inventory, String name, String productID, double price, int qty);

  void upgradeProductInQty(Inventory inventory, String productID, int amount);

  void sellProduct(Inventory inventory, Report report, String productID, int qty);
}
