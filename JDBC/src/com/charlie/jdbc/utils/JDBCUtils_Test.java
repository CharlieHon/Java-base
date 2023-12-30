package com.charlie.jdbc.utils;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils_Test {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    private static String mysqlPath = "src\\mysql.properties";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils_Test.getConnection();
        String sql = "select * from admin";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pwd = resultSet.getString("pwd");
            System.out.println(id + "\t" + name + "\t" + pwd);
        }
        JDBCUtils_Test.close(resultSet, preparedStatement, connection);
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(mysqlPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");
    }

    public static Connection getConnection() {
//        Class.forName(driver);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(ResultSet set, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
