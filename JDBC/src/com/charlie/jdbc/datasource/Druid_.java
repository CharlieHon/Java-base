package com.charlie.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        // 1. 加入 Druid jar包
        // 2. 加入 配置文件 到 src 目录下
        // 3. 创建 Properties 对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        // 4. 创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("连接成功...");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Druid连接池，连接5000次耗时：" + (end - start));  // 260
    }
}
