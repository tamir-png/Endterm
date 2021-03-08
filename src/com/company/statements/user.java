package com.company.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

public class user {

    public static void seeAllUsers() {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop","postgres", "tamir123456789");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

            stmt = c.createStatement();

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

            //--------------- INSERT ROWS ---------------



            sql = "INSERT INTO users (user_id, user_name, user_phone, user_address, credit_cart_id) VALUES (8, '" + name + "','" + phones + "','" + address + "','" + cart + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
