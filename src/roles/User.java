package roles;

public abstract class User {
  private String username, password, role;

  public User(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public boolean isAuth(String password) {
    return this.password.equals(password);
  }

  public String getRole() {
    return role;
  }
}
