package com.charlie.jdbc.datasource;

import com.charlie.jdbc.utils.JDBCUtils_Test;
import org.junit.Test;

import java.sql.Connection;

public class ConnQuestion {
    // 测试连接MySQL 5000次
    @Test
    public void testConn() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 使用传统jdbc方式，得到连接
            Connection connection = JDBCUtils_Test.getConnection();
            // 这里可以做一些工作，比如得到 preparedStatement
            /********** 不断开连接会报错 ： "Too many connections"  ***************/
            // 关闭
            JDBCUtils_Test.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式连接5000次，耗时：" + (end - start));  // 4145ms
    }
}
