# unique的使用
CREATE TABLE t5 (
	id INT UNIQUE, -- 表示id列是不可以重复的
	`name` VARCHAR(32),
	email VARCHAR(32)
);
INSERT INTO t5 VALUES (1, 'jack', 'jack@163.com');
INSERT INTO t5 VALUES (1, 'tom', 'tom@sohu.com'); # 错误：Duplicate entry '1' for key 'id'
-- unique使用细节
-- 1. 如果没有指定 not null ，则 unique字段可以有多个null
INSERT INTO t5 VALUES (NULL, 'kiki', 'kiki@sohu,com');
INSERT INTO t5 VALUES (NULL, 'lily', 'lily@sohu,com');
SELECT * FROM t5;
-- 2. 一张表可以有多个unique字段
CREATE TABLE t6 (
	id INT UNIQUE,
	`name` VARCHAR(32) UNIQUE,
	email VARCHAR(32)
);
