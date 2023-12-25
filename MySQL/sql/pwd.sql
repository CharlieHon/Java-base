# 演示加密函数和系统函数
-- user() 查询当前是哪个用户在使用数据库
-- 可以查看登录到mysql的有些用户，以及登录的IP
SELECT USER() FROM DUAL;	-- 用户名@IP地址
-- database() 查询当前使用的数据库
SELECT DATABASE();

-- md5(str) 为字符串算出一个mds 32的字符串，常用加密
--	root密码是 hsp -> md5加密 -> 在数据库中存放的是加密后的密码
SELECT MD5('hsp') FROM DUAL;
SELECT LENGTH(MD5('hsp')) FROM DUAL; -- 32

-- 演示用户表，存放密码时，是md5
CREATE TABLE users (
	id INT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	pwd CHAR(32) NOT NULL DEFAULT ''
	);
INSERT INTO users VALUES (100, '李自成', MD5('lzc'));
SELECT * FROM users;
SELECT * FROM users WHERE `name` = '李自成' AND pwd = MD5('lzc');
-- password(str) 加密函数，Mysql数据库的用户密码就是 PASSWORD函数加密
SELECT PASSWORD('hsp');
SELECT LENGTH(PASSWORD('hsp'));	-- 41
-- 查看数据库mysql中表user下用户信息
SELECT * FROM mysql.user WHERE `user` = 'root';
