# 主键的使用
-- id name email
CREATE TABLE t2 (
	id INT PRIMARY KEY, -- 表示id列是主键
	`name` VARCHAR(32),
	email VARCHAR(32)
);
-- 主键列的值不可以重复
INSERT INTO t2 VALUES (1, 'jack', 'jack@sohu,com'), (2, 'tom', 'tom@sohu,com');
SELECT * FROM t2;
INSERT INTO t2 VALUES (1, 'hsp', 'hsp@163.com'); # 错误：Duplicate entry '1' for key 'PRIMARY'
# 主键使用的细节讨论
/*
1. primary key 不可以重复，也不能为空
2. 一张表中最多只能有一个主键，但可以是复合主键(比如id+name)
3. 主键指定的方式有两种
	1. 直接在字段名后面指定 field primary key
	2. 在表定义最后写 primary key (列名);
*/
-- 2) 演示复合主键
CREATE TABLE t3 (
	id INT,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY (id, `name`) -- 这里就是复合主键
);
INSERT INTO t3 VALUES (1, 'jack', 'jack@sohu,com'), (2, 'tom', 'tom@sohu,com');
INSERT INTO t3 VALUES (1, 'hsp', 'hsp@163.com'); -- 正确：复合主键要求只要不全部相同，就可以添加
INSERT INTO t3 VALUES (1, 'hsp', 'xxx@163.com'); -- 错误：Duplicate entry '1-hsp' for key 'PRIMARY'
SELECT * FROM t3;
-- 3) 指定主键
CREATE TABLE t4 (
	id INT,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY(id)
);
-- 使用desc表名，可以查看primary key的情况
DESC t3;
