package com.charlie.jdbc.myjdbc;

/**
 * mysql 数据库实现 jdbc 接口
 */
public class MysqlJdbcImp implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("mysql 连接关闭");
    }
}
