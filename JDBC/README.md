# JDBC

## JDBC概述

1. JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题
2. Java程序员使用JDBC，可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作
3. JDBC的基本原理
   - ![img.png](img.png)
4. JDBC带来的好处
   - ![img_1.png](img_1.png)
5. JDBC是Java提供一套用于数据库操作的接口API，**Java程序员只需要面向这套接口编程即可**。
   不同的数据库厂商，需针对这套接口，提供不同的实现。

**JDBC程序编写步骤**
1. 注册驱动-加载Driver类
2. 获取连接-得到Connection
3. 执行增删改查-发送SQL给mysql执行
4. 释放资源-关闭相关连接
5. ![img_2.png](img_2.png)

```java
package com.charlie.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 第一个jdbc程序，完成简单的操作
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        /*
        前置工作：在项目下创建一个文件夹比如 libs
        将 mysql.jar 拷贝到该目录下，点击 add to project 加入到项目中
         */

        // 1. 注册驱动
        Driver driver = new Driver();   // 创建driver对象

        // 2. 得到连接
        /*
        1) jdbc:mysql:// 规定好的表示协议，通过jdbc方式连接mysql
        2) localhost 主机，可以是IP地址
        3) 3306 表示mysql监听的接口
        4) /hsp_db02 表示连接到 mysql dbms 的哪个数据库
        5) mysql的连接本质上就是 socket 连接
         */
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
       // 将用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        // 说明：user和password是规定号的，后面的值根据实际情况写
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "011121"); // 密码

        Connection connect = driver.connect(url, properties);

        // 3. 执行sql
//        String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '135')";
//        String sql = "update actor set `name` = '周星驰' where id = 1";
        String sql = "delete from actor where id = 1";

        // statement 用于执行静态SQL语句并返回生成结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);    // 如果是dml语句，返回的就是影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");

        // 4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
```

## 获取数据库连接的5种方式

> 提示：
> 1. mysql驱动5.1.6可以无需 `Class.forName("com.mysql.jdbc.Driver");`
> 2. 从jdk1.5以后使用jdbc4，不需要再显式调用 `Class.forName()` 注册驱动而是自动调用驱动
>     jar包下 `META-INF\services\java.sql.Driver` 文本种的类名称去注册
> 3. 建议写上 `Class.forName()` 更加明确

- ![img_3.png](img_3.png)

```java
package com.charlie.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Java连接mysql的5种方式
 */
public class JdbcConn {

    public static void main(String[] args) throws Exception {
        // 使用方式5完成练习
        Properties properties = new Properties();
        String fileName = "src\\mysql.properties";
        properties.load(new FileInputStream(fileName));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql1 = "create table news " +
                "(id int primary key auto_increment," +
                "`name` varchar(32) not null default ''," +
                "content text not null);";
        int row1 = statement.executeUpdate(sql1);
        System.out.println(row1 > 0 ? "创建成功" : "创建失败");

        String sql2 = "insert into news values" +
                "(null, '北京日报', '建设美丽中国')," +
                "(null, '今晚报', '自由民主')," +
                "(null, '联合早报', '花园城市')," +
                "(null, '南方周末', '民以食为天')," +
                "(null, '新京报', '跨年');";
        int row2 = statement.executeUpdate(sql2);
        System.out.println(row2 > 0 ? "添加成功" : "添加失败");

        String sql3 = "update news set content = 'hello, world' where id = 1;";
        int row3 = statement.executeUpdate(sql3);
        System.out.println(row3 > 0 ? "修改成功" : "修改失败");

        String sql4 = "delete from news where id = 3;";
        int row4 = statement.executeUpdate(sql4);
        System.out.println(row4 > 0 ? "删除成功" : "删除失败");

        // 关闭连接资源
        statement.close();
        connection.close();
    }

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();   // 创建 driver 对象
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "011121");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式1：" + connect);
    }

    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 使用反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "011121");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2：" + connect);
    }

    @Test
    public void connect03() throws Exception {
        // 使用 DriverManager 替代 Driver 进行统一管理
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        // 创建 url user 和 password
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "011121";

        DriverManager.registerDriver(driver); // 注册
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3：" + connection);
    }

    @Test /* 推荐使用 */
    public void connect04() throws Exception {
        // 方式4：使用 Class.forName 自动完成注册驱动，简化代码
        // 在加载Driver类是，完成注册
        /*
        1. 静态代码块，在类加载时，会执行一次
        2. DriverManager.registerDriver(new Driver());
        3. 因此注册driver的工作已经完成
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "011121";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式4：" + connection);
    }

    // 方式5：在方式4的基础商改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        // 通过 Properties对象 获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);  // 建议写上

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式5：" + connection);
    }
}
```

## ResultSet结果集

1. `ResultSet`表示数据库结果集的数据表，通常通过执行擦汗寻数据库的语句生成
2. `ResultSet`对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前
3. `next`方法将光标移动到下一行，并且由于在 `ResultSet` 对象种没有更多行时返回 `false`
   因此可以在 while循环种使用循环来遍历结果集
- ![img_4.png](img_4.png)

```java
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
```

## Statement

1. `Statement`对象，用于执行静态SQL的语句并返回其生成的结果的对象
2. 在连接建立后，需要对书库进行访问，执行命令或是SQL语句，可以通过
   - Statement-存在SQL注入
   - PreparedStatement-预处理
   - CallableStatement-存储过程
3. `Statement`对象执行SQL语句，存在**SQL注入**风险
4. SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法SQL语句段或命令
   恶意国际数据库
5. 要防范SQL注入，只要用 `PreparedStatement` 取代 Statement 即可

```java
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
```

## PreparedStatement

1. `PreparedStatement`执行的SQL语句中的参数用问号`?`表示，调用`PreparedStatement`对象的`setXXX()`方法来设置这些参数
   `setXXX()`方法有两个参数，第一个参数是要设置的SQL语句中的参数的索引(从1开始)，第二个是设置的SQL语句中的参数的值
2. 调用 `executeQuery()` 返回 `ResultSet` 对象
3. 调用 `executeUpdate()` 执行更新，包括增、删、修改
4. ![预处理优点](img_5.png)

```java
package com.charlie.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementExercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // 注册驱动
        String mysqlPath = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(mysqlPath));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 建立连接
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        // sql：创建admin表
        String sql1 = "create table admin (" +
                "id int primary key auto_increment," +
                "name varchar(32) not null default ''," +
                "pwd varchar(32) not null default ''" +
                ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        int rows1 = preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println(rows1 > 0 ? "创表成功！" : "创表失败~");

        // sql：添加数据
//        String sql2 = "insert into admin values" +
//                "(null, 'jack', '123')," +
//                "(null, 'tom', '666')," +
//                "(null, 'hsp', 'hsp')," +
//                "(null, 'lzc', '111')," +
//                "(null, 'charlie', '777');";
        Scanner scanner = new Scanner(System.in);
        String adminName = "";
        String adminPwd = "";
        String sql2 = "insert into admin values" +
                "(null, ?, ?);";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入管理员姓名：");
            adminName = scanner.nextLine();
            System.out.print("请输入管理员密码：");
            adminPwd = scanner.nextLine();
            preparedStatement1.setString(1, adminName);
            preparedStatement1.setString(2, adminPwd);
            int j = preparedStatement1.executeUpdate();
            System.out.println(j > 0 ? "添加成功！" : "添加失败~");
        }
        preparedStatement1.close();

        // sql：修改记录
        String sql3 = "update admin set name = 'king' where name = 'tom'";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
        int rows2 = preparedStatement2.executeUpdate();
        System.out.println(rows2 > 0 ? "修改成功！" : "修改失败~");

        // sql：删除记录
        String sql4 = "delete from admin where name = ?";
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql4);
        System.out.print("请输入要删除的管理员姓名：");
        adminName = scanner.nextLine();
        preparedStatement3.setString(1, adminName);
        int rows3 = preparedStatement3.executeUpdate();
        preparedStatement3.close();
        System.out.println(rows3 > 0 ? "删除成功！" : "删除失败~");

        // sql：查询全部记录，并显示在控制台
        String sql = "select * from admin";
        PreparedStatement preparedStatement4 = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement4.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String pwd = resultSet.getString(3);
            System.out.println(id + "\t" + name + "\t" + pwd);
        }

        // 关闭连接
        preparedStatement4.close();
        connection.close();
    }
}
```

## JDBC相关API小结

- **JDBC API**
  - `DriverManager`驱动管理类
    - `getConnection(url, user, pwd)`获取到连接
  - `Connection`接口
    - `createStatement`创建`Statement`对象
    - `preparedStatement(sql)`生成预处理对象
  - `Statement`接口
    - `executeUpdate(sql)`执行dml语句，返回影响的行数
    - `executeQuery(sql)`执行查询，返回`ResultSet`对象
    - `execute(sql)`执行任意的sql语句，返回布尔值
  - `PreparedStatement`接口
    - `executeUpdate(sql)`执行dml语句
    - `executeQuery(sql)`执行查询，返回`ResultSet`对象
    - `execute(sql)`执行任意的sql语句，返回布尔值
    - `setXXX(占位符索引, 占位符的值)` 解决SQL注入问题
    - `setObject(占位符索引, 占位符的值)`
  - `ResultSet`结果集
    - `next()`向下移动一行，如果没有下一行，返回`false`
    - `previous()`向上移动，如果没有上一行，返回`false`
    - `getXXX(列索引/列名)`，返回对应列的值，返回类型是XXX
    - `getObject(列索引/列名)`返回对应列的自豪，接收类型为`Object`

## 封装JDBCUtils

- [JDBCUtils](src/com/charlie/jdbc/utils/JDBCUtils.java)
- [测试工具类](src/com/charlie/jdbc/utils/JDBCUtils_Use.java)

```java
package com.charlie.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类，完成 mysql 的连接和关闭资源
 */
public class JDBCUtils {
    // 定义相关的属性(4个)，因为只需要一份，所以做成static
    private static final String user;
    private static final String password;
    private static final String url;
    private static final String driver;

    // 在static代码块中初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            // 读取相关的属性值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 在实际开发中，可以这样梳理
            // 1. 将编译异常转成运行异常
            // 2. 这时调用者可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    // 连接数据库，返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭资源
    /*
    1. ResultSet 结果集
    2. Statement 或者 PreparedStatement
    3. Connection
    4. 如果需要关闭资源，就传入对象，否则传入null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        // 判断是否为null
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // 将编译异常转成运行异常
            throw new RuntimeException(e);
        }
    }
}
```

```java
package com.charlie.jdbc.utils;

import org.junit.Test;

import java.sql.*;

/**
 * 演示如何使用 JDBCUtils 工具类，完成dml和select
 */
public class JDBCUtils_Use {
    public static void main(String[] args) {

    }

    @Test
    public void testDML() { // insert, update, delete
        // 1. 得到连接
        Connection connection = null;
        // 2. 编写sql
        String sql = "update actor set name = ? where id = ?;";
//        String sql = "insert into actor values (null, ?, null, null, ?)";
        // 3. 创建 PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给占位符赋值
            preparedStatement.setString(1, "李达康");
            preparedStatement.setInt(2, 2);
            // 执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from actor;";
            preparedStatement = connection.prepareStatement(sql);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String gender = set.getString("gender");
                Date date = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + gender + "\t" + date + "\t" + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }
}
```

## 事务

- ![img_6.png](img_6.png)

```java
package com.charlie.jdbc.transaction_;

import com.charlie.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示在JDBC中如何使用事务
 */
public class Transaction_ {

    @Test
    public void noTransaction() {
        // 1. 得到连接
        Connection connection = null;
        // 2. 编写sql
        String sql1 = "update account set balance = balance - 100 where id = 1;";
        String sql2 = "update account set balance = balance + 100 where id = 2;";
        // 3. 创建 PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection(); // connection在默认情况下是自动提交的
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();  // 执行第一条sql

            int i = 1 / 0;  // 没有使用事务

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();  // 执行第二条sql
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void useTransaction() {
        // 1. 得到连接
        Connection connection = null;
        // 2. 编写sql
        String sql1 = "update account set balance = balance - 100 where id = 1;";
        String sql2 = "update account set balance = balance + 100 where id = 2;";
        // 3. 创建 PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            // 将 connection 设置为不自动提交
            connection.setAutoCommit(false);    // 相当于在这开启了事务

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();  // 执行第一条sql

//            int i = 1 / 0;  // 模拟异常

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();  // 执行第二条sql

            // 在这里提交事务
            connection.commit();
        } catch (Exception e) {
            // 这里可以进行回滚，即撤销执行的SQL
            System.out.println("执行发生了异常，撤销执行的sql语句");
            try {
                // 默认回滚到事务开始的状态
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
```

## 批处理

- 当需要成批插入或者更新记录时，可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理，
  通常情况下比单独提交处理更有效率
- ![img_7.png](img_7.png)
- JDBC连接Mysql时，如果要使用批处理功能，需要在url中加入参数 `?rewriteBatchedStatements=true`，如
  `url=jdbc:mysql://localhost:3306/hsp_db02?rewriteBatchedStatements=true`

```java
package com.charlie.jdbc.batch_;

import com.charlie.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示java批处理
 */
public class Batch_ {

    // 传统方法，添加5000条数据到admin2
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("===开始执行===");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {    // 5000次循环
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法 耗时：" + (end - start)); // 2477ms
        // 关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }

    // 使用批量方式添加数据
    @Test
    public void batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";  // 注意sql语句的末尾不要加分号 ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("===开始执行===");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {    // 5000次循环
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");

            // 将sql语句加入到批处理包中
            /*  看源码 addBatch()
                1. 第一次会创建 ArrayList - elementData => Object[]
                2. elementData => Object[] 存放预处理的sql语句
                3. 当elementData满后，就按照1.5倍扩容
                4. 当添加到指定值后，就执行批量处理 executeBatch
                5. 批量处理会减少发送sql语句的次数，而且减少编译次数，因此效率提高
                public void addBatch() throws SQLException {
                    synchronized(this.checkClosed().getConnectionMutex()) {
                        if (this.batchedArgs == null) {
                            this.batchedArgs = new ArrayList();
                        }

                        for(int i = 0; i < this.parameterValues.length; ++i) {
                            this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                        }

                        this.batchedArgs.add(new BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                    }
                }
             */
            preparedStatement.addBatch();
            // 当有1000条记录时，再批量执行
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                // 清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时：" + (end - start)); //批量方式耗时： 34ms
        // 关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
```
