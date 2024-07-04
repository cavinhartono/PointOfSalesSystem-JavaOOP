import models.POSSystem;
import models.Product;
import roles.User;
import roles.Admin;
import roles.Cashier;
import roles.Action;

import java.util.Scanner;

public class App {
    private static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        POSSystem system = new POSSystem();

        // system.getUsers().add(new Admin("cavinhartono", "master123"));
        // system.getUsers().add(new Cashier("fikiazhar", "kasir123"));
        system.loadUsers("src\\Users.txt");
        system.loadProducts("src\\Products.txt");
        system.loadReports("src\\data\\Reports.txt");

        System.out.print("Masukan username: ");
        String username = ip.nextLine();
        System.out.print("Masukan password: ");
        String password = ip.nextLine();
        User auth = system.login(username, password);

        if (auth != null) {
            boolean isExit = false;

            System.out.println("Sukses!\n");
            System.out.println("Selamat datang, " + auth.getUsername() + ".");
            while (!isExit) {
                int number = 1;
                String[] Menus = { "Tambah Produk", "Update Stok Produk", "Mencari Produk", "Menampilkan Semua Produk",
                        "Menjual Produk", "Laporan Hari Ini", "Laporan Kemarin", "Keluar" };

                System.out.println();

                for (String menu : Menus) {
                    System.out.println("Tekan " + number + " " + menu);
                    number++;
                }
                System.out.print("Pilih: ");
                int option = ip.nextInt();

                System.out.println();

                Action action = (Action) auth;

                switch (option) {
                    case 1:
                        if (auth instanceof Admin) {
                            System.out.println("\n==/ Tambah Produk /==");
                            System.out.print("Masukan nama  : ");
                            String name = ip.nextLine();
                            System.out.print("Masukan ID    : ");
                            String productID = ip.nextLine();
                            System.out.print("Masukan harga : ");
                            double price = ip.nextDouble();
                            System.out.print("Masukan stok  : ");
                            int qty = ip.nextInt();
                            ip.nextLine();
                            System.out.println("==/ Tambah Produk /==");

                            action.addProduct(system.getInventory(), name, productID, price, qty);
                            System.out.println("Produk berhasil ditambahkan.");
                        } else {
                            System.err.println("\nTidak dapat diakses! Hanya Admin bisa menambahkan produk.");
                        }
                        break;
                    case 2:
                        if (auth instanceof Admin) {
                            System.out.println("\n==/ Update Stok Produk /==");
                            System.out.print("Masukan No. Produk     : ");
                            String productID = ip.nextLine();
                            System.out.print("Masukan Tambahan Jumlah : ");
                            int qty = ip.nextInt();
                            System.out.println("==/ Update Stok Produk /==");

                            action.upgradeProductInQty(system.getInventory(), productID, qty);
                            System.out.println("Stok produk berhasil ditambahkan.");
                        } else {
                            System.err.println("\nTidak dapat diakses! Hanya Admin bisa menambahkan produk.");
                        }
                        break;
                    case 3:
                        System.out.println("\n==/ Mencari Produk /==");
                        System.out.print("Masukan No. Produk     : ");
                        String productID = ip.next();
                        System.out.println("==/ Mencari Produk /==");

                        Product product = system.getInventory().searchProductByID(productID);
                        if (product != null) {
                            System.out.println(
                                    "Produk ditemukan: " + "ID:" + product.getProductID() + " " + product.getName()
                                            + " | Rp. " + product.getPrice() + ", Tersisa: " + product.getQty());
                        } else {
                            System.out.println("\nProduk tidak ditemukan.");
                        }
                        break;
                    case 4:
                        System.out.println("\n==/ Menampilkan Semua Produk /==");
                        for (Product p : system.getInventory().getProducts()) {
                            System.out.println("ID:" + p.getProductID() + " " + p.getName() + " | Rp. " + p.getPrice()
                                    + ", Tersisa: " + p.getQty());
                        }
                        System.out.println("==/ Menampilkan Semua Produk /==");
                        break;
                    case 5:
                        if (auth instanceof Cashier) {
                            System.out.println("\n==/ Menampilkan Semua Produk /==");
                            for (Product p : system.getInventory().getProducts()) {
                                System.out.println("Produk ditemukan: " + "ID:" + p.getProductID() + " " + p.getName()
                                        + " | Rp. " + p.getPrice() + ", Tersisa: " + p.getQty());
                            }
                            System.out.println("==/ Menampilkan Semua Produk /==");

                            System.out.println("\n==/ Menjual Produk /==");
                            System.out.print("Masukan No. Produk: ");
                            String IDProduct = ip.next();
                            System.out.print("Jumlah            : ");
                            int qty = ip.nextInt();
                            System.out.println("==/ Menjual Produk /==");
                            action.sellProduct(system.getInventory(), system.getReport(), IDProduct, qty);
                        } else {
                            System.err
                                    .println("\nTidak dapat diakses! Hanya Kasir yang bisa menampilkan semua produk.");
                        }
                        break;
                    case 6:
                        system.getReport().printToday();
                        break;
                    case 7:
                        system.getReport().printYesterday();
                        break;
                    case 8:
                        isExit = true;
                        system.saveProducts("src\\Products.txt");
                        break;
                    default:
                        System.err.println("\nInvalid pilihan! Pilih yang ada di menu.");
                        break;
                }
            }
        } else {
            System.err.println("Login Gagal! Sesuaikan username dan password.");
        }
    }
}
