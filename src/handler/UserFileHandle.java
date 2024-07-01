package handler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import roles.User;
import roles.Admin;
import roles.Cashier;

public class UserFileHandle {
  public static List<User> loadUsers(String fileName) {
    List<User> Users = new ArrayList<>();

    try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
      String line;

      while ((line = rd.readLine()) != null) {
        String[] parts = line.split(",");

        if (parts.length == 3) {
          String username = parts[0], password = parts[1], role = parts[2];

          if (role.equals("admin")) {
            Users.add(new Admin(username, password));
          } else if (role.equals("cashier")) {
            Users.add(new Cashier(username, password));
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return Users;
  }

  public static void saveUsers(List<User> Users, String fileName) {
    try (BufferedWriter wr = new BufferedWriter(new FileWriter(fileName))) {
      for (User user : Users) {
        wr.write(user.getUsername() + "," + user.getPassword() + "," + user.getRole());
        wr.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
