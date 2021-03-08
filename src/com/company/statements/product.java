package com.company.statements;

import java.sql.*;


public class product {
    public static void TestDatabase() {

        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shop","postgres", "tamir123456789");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (1, 'Portable Blender', 11000, 'little cooker');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (2, 'Nail Polish', 5000, 'for beauty');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (3, 'Peel-off mask', 1000, 'anti-aging');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO product (product_id,product_name,product_price,product_description) VALUES (4, 'Phone Chargers', 5000, 'fast');";
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
        System.out.println("-- All Operations done successfully");

    }
    public static void Select() {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shop","postgres", "tamir123456789");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String description = rs.getString("product_description");
                System.out.println(String.format("ID=%s NAME=%s Price=%s DESCRIPTION=%s",id,name,price,description));
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
