package com.company.statements;

// ---------- Import ----------
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import java.sql.*;
import java.util.Scanner;

public class User {

    public static void createUser() {

        // ---------- Fields to use connection with query statements ----------
        Connection con;
        Statement stmt;

        try {

            // ---------- Connection through IDB and DB ----------
            IDB dataSource = new DB();
            con = dataSource.getConnection();

            // ---------- Asking user to write some information, and through scanner inserting his information if JAVA storage
            String sql;
            stmt = con.createStatement();
            Scanner scaner = new Scanner(System.in);
            Scanner addresss = new Scanner(System.in);
            System.out.println("You need to fill little blank");
            System.out.print("Your name: ");
            String name = scaner.nextLine();
            System.out.print("Your phone: ");
            int phones = scaner.nextInt();
            System.out.print("Your address: ");
            String address = addresss.nextLine();
            System.out.print("Your credit cart id: ");
            int cart = scaner.nextInt();

            // ---------- INSERT ROWS ----------
            sql = "INSERT INTO users (user_id, user_name, user_phone, user_address, credit_cart_id) VALUES ((select count(*) from users) + 1, '" + name + "','" + phones + "','" + address + "','" + cart + "');";
            stmt.executeUpdate(sql);

            // ---------- closing connection with database ----------
            stmt.close();
            con.commit();
            System.out.println("-- Records created successfully");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void seeAllUsers() {

        // ---------- Fields for connection and query statements ----------
        Connection con;
        Statement stmt;


        try {

            // ---------- Connection through IDB and DB ----------
            IDB dataSource = new DB();
            con = dataSource.getConnection();

            // ---------- SELECT ROWS ----------
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                int phone = rs.getInt("user_phone");
                String address = rs.getString("user_address");
                int cart = rs.getInt("credit_cart_id");
                System.out.printf("USER_ID=%s USER_NAME=%s USER_PHONE=%s USER_ADDRESS=%s USER_CREDIT_CART_ID=%s", id, name, phone, address, cart);
                System.out.println();
            }

            // ---------- closing connection ----------
            rs.close();
            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
