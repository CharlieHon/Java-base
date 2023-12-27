# 演示自增长的使用
-- 创建表
CREATE TABLE t7 (
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32) NOT NULL DEFAULT '',
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);
DESC t7;
-- 测试自增长的使用
INSERT INTO t7 
	VALUES (NULL, 'tom@qq.com', 'tom');
INSERT INTO t7 (email, `name`) VALUES ('lzc@163.com', 'lzc');
SELECT * FROM t7;

-- 修改默认的自增长开始值
CREATE TABLE t8 (
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32) NOT NULL DEFAULT '',
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);
ALTER TABLE t8 AUTO_INCREMENT = 100; -- 设置自增长的起始值
INSERT INTO t8 VALUES (NULL, 'tom@qq.com', 'tom');
# 如果指定自增长字段的值，则其值按照指定值来
INSERT INTO t8 VALUES (12, 'kiki@qq.com', 'kiki'); -- 12
-- 自增长从该列最大值开始
INSERT INTO t8 VALUES (NULL, 'vivo@qq.com', 'vivo'); -- 101
SELECT * FROM t8;
