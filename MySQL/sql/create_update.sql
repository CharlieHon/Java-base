# 创建一个员工表 emp
SELECT DATABASE();
# 删除数据库 db03
DROP DATABASE IF EXISTS db03;
# 查看当前有哪些数据库
SHOW DATABASES;
# 创建数据库 db01
CREATE DATABASE IF NOT EXISTS db01;
# 创建员工表 emp
CREATE TABLE emp (
	id INT,
	NAME VARCHAR(16),
	gender CHAR(1),
	birthday DATE,
	entry_date DATE,
	job VARCHAR(32),
	salary DOUBLE UNSIGNED,
	`resume` TEXT
	) CHARSET utf8 COLLATE utf8_general_ci ENGINE INNODB;
# 查看当前数据库有哪些表
SHOW TABLES;
# 查看表结构，可以查看表的所有列
DESC emp;


# 修改表
# 在 emp表 上增加一个 image列 varchar类型 要求在(resume列)后面
ALTER TABLE emp ADD image VARCHAR(16) NOT NULL DEFAULT '' 
			AFTER `resume`;	-- 在 resume字段 后面添加 image字段
# 修改 job列，使其长度为60
ALTER TABLE emp MODIFY job VARCHAR(60);
# 删除 gender列
ALTER TABLE emp DROP gender;
# 修改表名改为 employee
RENAME TABLE emp TO employee;
SHOW TABLES;	-- 查看发现已修改表名
DESC employee;
# 修改表的字符集为 utf8
ALTER TABLE employee CHARSET utf8;
# 将列名 name 修改为 user_name
ALTER TABLE employee CHANGE `name` use_name VARCHAR(32) NOT NULL DEFAULT '';
