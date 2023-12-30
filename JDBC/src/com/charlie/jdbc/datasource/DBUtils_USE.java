package com.charlie.jdbc.datasource;

import com.charlie.jdbc.utils.Actor;
import com.charlie.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * 基于Druid数据库连接池的工具类
 */
public class DBUtils_USE {

    // 使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
    @Test
    public void testQueryMany() throws SQLException {
        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口，先引进 DBUtils 相关的 jar，加入到本project
        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 就可以执行相关的方法，返回 ArrayList 结果集
//        String sql = "select * from actor where id >= ?";
        // 注意：sql语句也可以查询部分属性
        String sql = "select id, name from actor where id >= ?";

        /*
        1) query() 方法就是执行 sql语句，得到 resultSet --封装到--> ArrayList集合中
        2) 返回集合
        3) connection：连接
        4) sql：执行的sql语句
        5) new BeanListHandler<>(Actor.class) 在将resultSet -> Actor对象 -> 封装到 ArrayList
                底层使用反射机制获取 Actor类的属性，然后进行封装
        6) 1 就是传给 sql语句中的 ? 赋值，可以有多个值，因为是可变参数 Object... params
        7) 底层得到的 resultSet 会在 query 关闭，关闭 preparedStatement
         */
        /**
         *     public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         PreparedStatement stmt = null;   // 定义 PreparedStatement
         *         ResultSet rs = null;             // 接收返回的 ResultSet
         *         T result = null;                 // 返回 ArrayList
         *
         *         try {
         *             stmt = this.prepareStatement(conn, sql); // 创建 PreparedStatement
         *             this.fillStatement(stmt, params);        // 对 sql 进行 ? 赋值
         *             rs = this.wrap(stmt.executeQuery());     // 执行sql 返回 resultSet
         *             result = rsh.handle(rs);                 // 返回的 resultSet --> ArrayList[resultSet] 底层使用到反射机制
         *         } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *         } finally {
         *             try {
         *                 this.close(rs);                      // 关闭 resultSet
         *             } finally {
         *                 this.close((Statement)stmt);         // 关闭 preparedStatement
         *             }
         *         }
         *
         *         return result;
         *     }
         */
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合信息");
        for (Actor actor : list) {
            System.out.print(actor);
        }
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    // 演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        // 1. 得到连接 druid
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils类和接口，创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 3. 执行相关方法，返回单个对象
        String sql = "select * from actor where id = ?";
        /*
        因为知道返回的是单行记录 <----> 单个对象，使用 Handler 是 BeanHandler
         */
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
        if (actor != null) {
            System.out.println(actor);
        } else {
            System.out.println("查无此记录~");
        }
        // 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    // 演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        /*
        因为返回的是一个对象，使用的 handler 是 ScalarHandler
         */
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 3);
        if (obj == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(obj);
        }
        JDBCUtilsByDruid.close(null, null, connection);
    }

    // 演示 apache-dbutils + druid 完成 dml (update, insert, delete)
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        // 这里组织sql语句完成 update, insert, delete
//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor values (null, '侯亮平', '男', '1975-1-9', '166')";
        String sql = "delete from actor where id = ?";
        /*
        1. 执行 dml 操作是 queryRunner.update()
        2. 返回值是受影响的行数
         */
        int affectedRow = queryRunner.update(connection, sql, 4);
        System.out.println(affectedRow > 0 ? "执行成功！" : "执行未影响到表");
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
