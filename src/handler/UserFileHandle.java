package handler;

import java.io.*;
import java.util.List;

import roles.User;

public class UserFileHandle {
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
