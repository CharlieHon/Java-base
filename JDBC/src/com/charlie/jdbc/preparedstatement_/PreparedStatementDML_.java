package com.charlie.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示 PreparedStatement 使用 dml 语句
 */
public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {
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

        // 3. 得到 PreparedStatement
        // 3.1 组织sql语句，SQL语句中 ? 就相当于占位符
        // 3.2 preparedStatement 是实现了 PreparedStatement接口的实现类的对象

        // 添加记录
//        String sql = "insert into admin values(?, ?)";
        // 修改记录
//        String sql = "update admin set pwd = ? where name = ?";
        // 删除记录
        String sql = "delete from admin where name = ? and pwd = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name); // 占位符索引从1开始
        preparedStatement.setString(2, admin_pwd);

        // 4. 执行DML语句
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败~");

        // 5. 关闭连接
        preparedStatement.close();
        connection.close();
    }
}
