package com.company.data.interfaces;

import java.sql.*;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
