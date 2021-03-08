package com.company.data.interfaces;

// Import
import java.sql.*;

// Creating interface, to use connection from DB often
public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
