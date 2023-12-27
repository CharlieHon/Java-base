# 演示mysql的索引使用
USE db01;
CREATE TABLE t9 (
	id INT,
	`name` VARCHAR(32)
);
-- 查询表是否有索引
SHOW INDEXES FROM t9;
-- 添加索引
-- 添加唯一索引
CREATE UNIQUE INDEX id_index ON t9(id);
-- 添加普通索引1
CREATE INDEX id_index ON t9(id);
/* 如何选择
- 如果某列的值是不会重复的，则优先考虑使用unique索引，否则使用普通索引
*/
-- 添加普通索引方式2
ALTER TABLE t9 ADD INDEX id_index (id);

-- 添加主键索引
-- 1. 创建表时指定 primary key
-- 2. 创建表后指定
ALTER TABLE t9 ADD PRIMARY KEY (id);

-- 删除索引
DROP INDEX id_index ON t9;

-- 删除主键索引
ALTER TABLE t9 DROP PRIMARY KEY;

-- 修改索引，先删除，再添加新的索引

-- 查询索引
-- 1. 方式1
SHOW INDEX FROM t9;
-- 2. 方式2
SHOW INDEXES FROM t9;
-- 3. 方式3
SHOW KEYS FROM t9;
-- 4. 方式4
DESC t9;


# 练习
-- 方式1
CREATE TABLE t10 (
	id INT PRIMARY KEY,
	goods_name VARCHAR(32),
	customer VARCHAR(32)
);
-- 方式2
CREATE TABLE t11 (
	id INT,
	goods_name VARCHAR(32),
	customer VARCHAR(32)
);
ALTER TABLE t11 ADD PRIMARY KEY (id);
