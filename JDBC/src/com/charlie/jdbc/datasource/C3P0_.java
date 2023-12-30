package com.charlie.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.swing.plaf.IconUIResource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示c3p0的使用
 */
public class C3P0_ {
    // 方式1：相关参数，在程序中指定 user, url, password等
    @Test
    public void testC3P0_01() throws Exception {
        // 1. 创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // 2. 通过配置文件 mysql.properties 获取相关的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        // 3. 给数据源 comboPooledDataSource 设置相关的参数
        // 注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        // 设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        // 测试连接池的效率，连接mysql 5000次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 获取连接
            Connection connection = comboPooledDataSource.getConnection();
            // 关闭连接
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000次连接mysql，耗时：" + (end - start));    // 193
    }

    // 第二种方式：使用配置文件模板来完成
    // 1. 将c3p0提供的 c3p0.config,xml 拷贝到 src 目录下
    // 2. 该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_edu");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
//            System.out.println("连接成功~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000次连接mysql，耗时：" + (end - start));    // 197
    }
}
