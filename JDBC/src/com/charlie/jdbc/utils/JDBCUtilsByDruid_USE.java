package com.charlie.jdbc.utils;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * 基于Druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid_USE {

    @Test
    public ArrayList<Actor> testSelectToArrayList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        // 创建ArrayList对象，存放actor对象
        ArrayList<Actor> list = new ArrayList<>();

        try {
            connection = JDBCUtilsByDruid.getConnection();
            String sql = "select * from actor where id >= ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String gender = set.getString("gender");
                Date date = set.getDate("borndate");
                String phone = set.getString("phone");

                // 把得到的resultSet的记录，封装到Actor对象，放入到list集合
                list.add(new Actor(id, name, gender, date, phone));
            }
//            System.out.println("list集合数据：" + list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }

        // 因为 ArrayList 和 connection 没有任何关联，所以该集合可以在关闭连接后继续使用
        return list;
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            String sql = "select * from admin where id > ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String pwd = set.getString("pwd");
                System.out.println(id + "\t" + name + "\t" + pwd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
