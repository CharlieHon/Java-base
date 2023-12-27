# 事务的一个重要概念和具体操作
DROP TABLE t10;
-- 1. 创建一张测试表
CREATE TABLE t10 (
	id INT,
	`name` VARCHAR(32)
);
-- 2. 开始事务
START TRANSACTION;
-- 3. 设置保存点
SAVEPOINT a;
-- 指定dml操作
INSERT INTO t10 VALUES (1, 'tom');
SAVEPOINT b;
-- 执行dml操作
INSERT INTO t10 VALUES (2, 'charlie');

-- 回退到b
ROLLBACK TO b;
-- 回退到a
ROLLBACK TO a;
# 查询
SELECT * FROM t10;
-- 如果这样写，表示直接回退到事务开始的状态
ROLLBACK;
COMMIT;
