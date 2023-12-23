# 修改表的操作练习
SELECT DATABASE();
USE hsp_db02;
SELECT * FROM emp;
# 员工表emp上增加一个 image列 varchar类型 (要求子啊resume后面)
ALTER TABLE emp ADD image VARCHAR(50) 
	NOT NULL 	-- 非空
	DEFAULT '' 	-- 默认 ''
	AFTER `resume`;	-- 在 resume字段 后

# 显示表结够，可以查看表的所有字段/列
DESC emp;
# 修改job列，使其长度为60
ALTER TABLE emp MODIFY job VARCHAR(60) NOT NULL DEFAULT '';
# 删除 image列
ALTER TABLE emp DROP image;
# 修改表名为 employee
RENAME TABLE emp TO employee;
-- 查看当前数据库有哪些表
SHOW TABLES;
# 修改表字符集
ALTER TABLE employee CHARSET utf8;
# 把列名 name 修改为 user_name
ALTER TABLE employee 
	CHANGE `name` user_name	--  将原来 name列 改名为 user_name
	VARCHAR(32) NOT NULL DEFAULT '';
DESC employee;
