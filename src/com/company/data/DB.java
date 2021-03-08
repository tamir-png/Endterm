package com.company.data;

import java.sql.*;

public class DB {
    public Connection get_Connection() {
        Connection con = null;

        String connectionUrl = "jdbc:postgresql://localhost:5432/shop";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "tamir123456789");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return con;
    }
}