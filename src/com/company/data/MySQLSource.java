package com.company.data;

import com.company.data.interfaces.IDB;
import java.sql.*;

public class MySQLSource implements IDB {
    @Override
    public Connection getConnection() {
        Connection con = null;

        String connectionUrl = "jdbc:mysql://localhost:5432/shop";
        try {
            con = DriverManager.getConnection(connectionUrl, "mysql", "tamir123456789");
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
