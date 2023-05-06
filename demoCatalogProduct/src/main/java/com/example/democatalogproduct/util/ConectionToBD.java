package com.example.democatalogproduct.util;

import java.sql.*;

public class ConectionToBD {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/qlsp";
    private static String USER = "root";
    private static String PASSWORD = "Balam2003@";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement statement)  {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static void closeConnection(Connection conn, PreparedStatement statement)  {

        try {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
