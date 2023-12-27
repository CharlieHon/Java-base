# mysql用户管理
--  当做项目开发时，可以根据不同的开发人员，赋给他相应的Mysql操作权限
-- 所以，mysql数据库管理人员(root)，根据需求创建不同的用户，设置相应的权限
-- 1. 创建新用户
/*
1. 'charlie@localhost' 表示用户的完整信息 charlie用户名 localhost登录的IP
2. 123456密码，存放再mysql.user表的是经过 password('123456')加密后的
*/
CREATE USER 'charlie'@'localhost' IDENTIFIED BY '123456';
SELECT * FROM mysql.user;
DELETE FROM mysql.user WHERE `user` = 'charlie';

SELECT `host`, `user`, `authentication_string` FROM mysql.user;
-- 2. 删除用户
DROP USER 'charlie'@'localhost';
-- 1. 登录用户，
/*
不同的数据库用户，操作的库和表不相同
不同的数据库用户，登录到DBMS后，根据相应的权限，可以操作的数据库和数据对象(表，视图，触发器)不一样
*/

-- 4. 修改密码
SET PASSWORD = PASSWORD('abcdef');
-- 修改其他人的密码，需要权限
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456');
