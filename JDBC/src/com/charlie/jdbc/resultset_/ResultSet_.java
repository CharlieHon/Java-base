package com.charlie.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 演示一个查询语句返回 ResultSet
 */
public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        String mysqlFile = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(mysqlFile));
        // 获取相关值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        // 1. 注册驱动
        Class.forName(driver);
        // 2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 3. 得到statement
        Statement statement = connection.createStatement();
        // 4. sql语句
        String sql = "select id, name, gender, borndate from actor";
        // 执行给定的SQL语句，返回单个 ResultSet 对象
        ResultSet resultSet = statement.executeQuery(sql);
        /*
        +----+-----------+--------+---------------------+-------+
        | id | name      | gender | borndate            | phone |
        +----+-----------+--------+---------------------+-------+
        |  2 | 李自成    | 男     | 1997-12-20 00:00:00 | 136   |
        |  3 | 高育良    | 男     | 1950-08-07 00:00:00 | 166   |
        +----+-----------+--------+---------------------+-------+
         */

        // 5. 使用while取出数据
        while (resultSet.next()) {  // 让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1);    // 获取该行的第1列数据
//            int id1 = resultSet.getInt("id"); // 通过列名获取值
            String name = resultSet.getString(2); // 第2列
            String gender = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + gender + "\t" + date);
        }

        // 6. 关闭连接
        statement.close();
        connection.close();
    }
}
