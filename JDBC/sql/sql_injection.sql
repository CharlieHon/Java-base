# 演示SQL注入
-- 创建一张表
CREATE TABLE admin (
	`name` VARCHAR(32) NOT NULL UNIQUE,
	pwd VARCHAR(32) NOT NULL DEFAULT ''
) CHARSET utf8;
-- 添加数据
INSERT INTO admin VALUES ('tom', '123');
-- 查找某个管理是否存在
SELECT * FROM admin
	WHERE `name` = 'tom';
-- SQL
-- 输入用户名 为 1' or '
-- 输入密码为 or '1' = '1
SELECT * FROM admin
	WHERE `name` = '1' OR' and pwd = ' OR '1' = '1';
SELECT * FROM admin;
