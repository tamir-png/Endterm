package com.company.statements;

// ---------- Imports ----------
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import java.sql.*;


public class Product {
    // ---------- I used this method once, to insert some data to product table, by repeatly using it is helpless ----------
    public static void TestDatabase() {

        // ---------- Fields for connection and query statements ----------
        Connection con;
        Statement stmt;

        try {

            // ---------- connecting with database through IDB and DB ----------
            IDB dataSource = new DB();
            con = dataSource.getConnection();

            String sql;

            // ---------- INSERT ROWS ----------
            stmt = con.createStatement();
            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (1, 'Portable Blender', 11000, 'little cooker');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (2, 'Nail Polish', 5000, 'for beauty');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (3, 'Peel-off mask', 1000, 'anti-aging');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (4, 'Phone Chargers', 5000, 'fast');";
            stmt.executeUpdate(sql);

            // ---------- closing connection ----------
            stmt.close();
            con.commit();
            System.out.println("-- Records created successfully");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("-- All Operations done successfully");

    }
    public static void Select() {

        // ---------- Fields for connection and query statements ----------
        Connection con;
        Statement stmt;

        try {

            // ---------- Connecting with database through IDB and DB ----------
            IDB dataSource = new DB();
            con = dataSource.getConnection();

            String sql;

            // ---------- SELECT ROW ----------
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String description = rs.getString("product_description");
                System.out.println(String.format("ID=%s NAME=%s Price=%s DESCRIPTION=%s",id,name,price,description));
            }

            // ---------- closing connection ----------
            rs.close();
            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
