# 用户管理细节
-- 不指定登录IP，则为%，表示所有IP都有连接权限
CREATE USER 'hsp';
SELECT `host`, `user` FROM mysql.user;
-- 指定IP字段
-- '192.168.1.%'表示xxx与在192.168.1.*的ip都可以登录
CREATE USER 'jack'@'192.168.1.%';
-- 在删除用户时，如果host不是%，需要明确指定 '用户名'@'host值'
DROP USER hsp; -- 默认就是 drop user 'hsp'@'%'
DROP USER 'charlie'@'localhost';
