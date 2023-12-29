package com.charlie.jdbc.statement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示SQL注入问题
 */
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        // 让用户输入管理员名和密码
        System.out.print("请输入管理员的名字："); // next() 当接受到 空格 或者 单引号 时表示结束
        String admin_name = scanner.nextLine(); // 如果希望看到SQL注入，需要用 nextLine()
        System.out.print("请输入管理员的密码：");
        String admin_pwd = scanner.nextLine();

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
//        String sql = "select name, pwd from admin";
        String sql = "select name, pwd from admin where name = '"
                + admin_name + "' and pwd = '" + admin_pwd + "';";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) { // 如果查询到一条记录，则说明该管理存在
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败~");
        }

        // 6. 关闭连接
        statement.close();
        connection.close();
    }
}
