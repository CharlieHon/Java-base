# 事务使用细节
-- 1. 如果不开启事务，默认情况下，dml操作时自动提交的，不能回滚
INSERT INTO t10 VALUES (1, 'charlie');
SELECT * FROM t10;
-- 2. 如果开启一个事务，没有创建保存点，可以执行rollback
-- 默认就是回退到事务开始的状态
START TRANSACTION;
INSERT INTO t10 VALUES (2, 'tom');
INSERT INTO t10 VALUES (3, 'hsp');
ROLLBACK; -- 表示直接回退到事务开始的状态
-- 3. 可以在事务还没提交时，创建多个保存点
-- 4. 可以在事务没有提交前，选择回退到那个保存点
-- 5. mysql需要使用InnoDB引擎才能使用事务，MyISAM不支持
-- 6. 开始一个事务 start transaction; set autocommit=off;
-- set autocommit=off;
