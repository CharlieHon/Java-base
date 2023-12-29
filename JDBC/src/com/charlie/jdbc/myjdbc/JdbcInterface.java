package com.charlie.jdbc.myjdbc;

/**
 * 自己规定的jdbc连接(方法)
 */
public interface JdbcInterface {
    // 连接
    public Object getConnection();
    // crud
    public void crud();
    // 关闭连接
    public void close();
}
