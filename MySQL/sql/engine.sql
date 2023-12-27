# 表类型和存储引擎
-- 查看所有的存储引擎
SHOW ENGINES;
-- innodb存储引擎
-- 1.支持事务 2.支持外键 3.支持行级锁

-- myisam存储引擎
CREATE TABLE t13 (
	id INT,
	`name` VARCHAR(32)
) ENGINE MYISAM;
-- 1. 添加速度块2.不支持事务和外键3.支持表级锁
START TRANSACTION;
SAVEPOINT t1;
INSERT INTO t13 VALUES (1, 'hsp');
SELECT * FROM t13;
ROLLBACK TO t1; -- 警告，不支持事务

-- memory 存储引擎
-- 1. 数据存储在内存中 2. 执行速度块(没有IO读写) 3.默认支持索引(hash表)
CREATE TABLE t14 (
	id INT,
	`name` VARCHAR(32)
) ENGINE MEMORY;
INSERT INTO t14 VALUES (1, 'tom'), (2, 'jack'), (3, 'charlie');
SELECT * FROM t14;
