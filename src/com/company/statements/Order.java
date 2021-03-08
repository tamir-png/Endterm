package com.company.statements;

// ---------- Imports ----------
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import java.sql.*;
import java.util.Scanner;

public class Order {
        public static void createOrder() {

            // Important fields for connection and query statements ----------
            Connection con;
            Statement stmt;

            try {

                // Making connection through IDB and DB
                IDB dataSource = new DB();
                con = dataSource.getConnection();
                String sql;
                stmt = con.createStatement();

                // Asking user to get some information for order, and through scanner iserting values in JAVA storage ----------
                Scanner scanner = new Scanner(System.in);
                System.out.println("To make order, fill one more blank");
                System.out.print("Your credit_cart_id: ");
                int cart = scanner.nextInt();
                System.out.println("Write your wanted product id: ");
                int producta = scanner.nextInt();
                System.out.print("Write today's day: ");
                int day = scanner.nextInt();

                // ---------- INSERT ROWS ----------
                sql = "INSERT INTO orders (order_id, user_id, credit_cart_id, product_id, date_created) VALUES ((select count(*) from orders) + 1, (select count(*) from users) , '" + cart + "', '" + producta + "', '" + day + "')";
                stmt.executeUpdate(sql);

                // Closing connection ----------
                stmt.close();
                con.commit();
                System.out.println("Order created");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.print(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
}
