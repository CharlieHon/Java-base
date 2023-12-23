# 创建表练习
SELECT DATABASE();	-- 显示当前数据库
CREATE TABLE emp (
	id INT,
	`name` VARCHAR(32),
	gender CHAR(1),
	birthday DATE,
	entry_date DATETIME,
	job VARCHAR(32),
	salary DOUBLE UNSIGNED,
	`resume` TEXT
	) CHARSET utf8 COLLATE utf8_bin ENGINE INNODB;
-- drop table emp;
INSERT INTO emp VALUES (100, '张三', '男', '2000-12-20', '2023-12-23 10:00:00', '后端开发', 35.5, 'CRUD');
SELECT * FROM emp;
