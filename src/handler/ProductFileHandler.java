package handler;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductFileHandler {
  public static List<Product> loadProducts(String fileName) {
    List<Product> Products = new ArrayList<>();

    try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = rd.readLine()) != null) {
        String[] parts = line.split(",");

        if (parts.length == 4) {
          String ID = parts[0];
          String name = parts[1];
          double price = Double.parseDouble(parts[2]);
          int qty = Integer.parseInt(parts[3]);

          Products.add(new Product(name, ID, price, qty));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return Products;
  }
}
