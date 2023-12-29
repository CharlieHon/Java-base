package com.charlie.jdbc.myjdbc;

/**
 *
 */
public class TestJDBC {
    public static void main(String[] args) {
        // 完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImp();
        jdbcInterface.getConnection();   // 通过接口来调用实现类[动态绑定]
        jdbcInterface.crud();
        jdbcInterface.close();

        // 完成对oracle的操作
        System.out.println("===================");
        JdbcInterface jdbcInterface1 =  new OracleJdbcImpl();
        jdbcInterface1.getConnection();
        jdbcInterface1.crud();
        jdbcInterface1.close();
    }
}
