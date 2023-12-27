# 用户权限管理
CREATE USER 'hsp'@'localhost' IDENTIFIED BY '123';
-- 使用root用户创建testdb，表news
CREATE DATABASE IF NOT EXISTS testdb;
CREATE TABLE news (
	id INT,
	content VARCHAR(32)
);
-- 添加一条测试数据
INSERT INTO news VALUES (100, '联合早报');
SELECT * FROM news;
-- 给hsp用户 分配查看 news 表和 添加news的权限
GRANT SELECT, INSERT ON testdb.news TO 'hsp'@'localhost';
-- 修改hsp密码
SET PASSWORD FOR 'hsp'@'localhost' = '123456';
-- 回收hsp用户在testdb.news表的所有权限
REVOKE SELECT, UPDATE, INSERT ON testdb.news FROM 'hsp'@'localhost';

-- 删除用户hsp
DROP USER 'hsp'@'localhost';
SELECT * FROM mysql.user;
