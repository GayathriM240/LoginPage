package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to your MySQL database
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user_db", // Change "user_db" to your database name
                "root", // MySQL username
                "gayi64" // MySQL password
        );
    }
}
