package models;

import java.util.ArrayList;
import java.util.List;

import handler.ProductFileHandler;
import handler.UserFileHandle;
import roles.User;

public class POSSystem {
  private List<User> Users;
  private Inventory inventory;
  private Report report;

  public POSSystem() {
    // Products = new ArrayList<>();
    inventory = new Inventory();
    Users = new ArrayList<>();
    report = new Report();
  }

  public User login(String username, String password) {
    for (User user : Users) {
      /*
       * Apakah username (maupun uppercase atau lowercase) dan password sesuai?
       * True: Mengambil data-data user tersebut
       * False: Tidak dapat lanjut ke sistem selanjutnya
       */
      if (user.getUsername().equalsIgnoreCase(username) && user.isAuth(password)) {
        return user;
      }
    }

    return null;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public Report getReport() {
    return report;
  }

  public List<User> getUsers() {
    return Users;
  }

  public void loadProducts(String fileName) {
    List<Product> Products = ProductFileHandler.loadProducts(fileName);

    for (Product product : Products) {
      inventory.setProduct(product);
    }
  }

  public void saveProducts(String fileName) {
    ProductFileHandler.saveProducts(inventory.getProducts(), fileName);
  }

  public void loadUsers(String fileName) {
    Users = UserFileHandle.loadUsers(fileName);
  }

  public void saveUsers(String fileName) {
    UserFileHandle.saveUsers(Users, fileName);
  }
}
