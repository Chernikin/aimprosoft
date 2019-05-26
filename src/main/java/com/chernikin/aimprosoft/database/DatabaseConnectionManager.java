package com.chernikin.aimprosoft.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private static final String MYSQL_DATABASE_URL = "jdbc:mysql://127.0.0.1:3307/aimprosoft";
    private static final String MYSQL_DATABASE_USERNAME = "root";
    private static final String MYSQL_DATABASE_PASSWORD = "Root";

    public static Connection getConnection() {
        try {
            final Connection connection = DriverManager.getConnection(MYSQL_DATABASE_URL, MYSQL_DATABASE_USERNAME, MYSQL_DATABASE_PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            // logger.error("Can't establish a new connection to the database")
            throw new DatabaseConnectionException("The database is unavailable", e);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
