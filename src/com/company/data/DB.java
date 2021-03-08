package com.company.data;

// Import
import com.company.data.interfaces.IDB;
import java.sql.*;

public class DB implements IDB {
    @Override
    public Connection getConnection() {

        // making connection with Database, and returning this connection
        Connection con = null;

        String connectionUrl = "jdbc:postgresql://localhost:5432/shop";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "tamir123456789");
            con.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return con;
    }
}