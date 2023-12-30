package com.charlie.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 基于Druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static final String druidProperties = "src\\druid.properties";
    private static final DataSource ds;

    // 测试 该工具类
    public static void main(String[] args) throws Exception {
        String sql = "select * from admin";
        Connection connection = JDBCUtilsByDruid.getConnection();
        // class com.alibaba.druid.pool.DruidPooledConnection
        System.out.println(connection.getClass());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pwd = resultSet.getString("pwd");
            System.out.println(id + "\t" + name + "\t" + pwd);
        }
        JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(druidProperties));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 关闭连接，注意：在数据库连接池技术中，close不是真正地断掉连接
    // 而是把使用的 Connection对象 放回到连接池
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
