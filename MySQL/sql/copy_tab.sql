# 表复制
CREATE TABLE my_tab01 (
	id INT,
	`name` VARCHAR(32),
	sal DOUBLE,
	job VARCHAR(32),
	deptno INT
	);
DESC my_tab01;
SELECT * FROM my_tab01;

-- 演示如何自我复制
-- 1. 先把 emp表 的记录复制到 my_tab01
INSERT INTO my_tab01(id, `name`, sal, job, deptno)	-- 不需要写 values
	(SELECT empno, ename, sal, job, deptno FROM emp);
-- 2. 自我复制
INSERT INTO my_tab01
	SELECT * FROM my_tab01;
SELECT COUNT(*) FROM my_tab01;
# 如何删除掉一张表的重复记录
-- 1. 先创建一张表 my_tab02
-- 2. 让 my_tab02 有重复的记录
CREATE TABLE my_tab02 LIKE emp;	-- 表示把 emp表的结构(列)，复制到my_tab02
DESC my_tab02;
INSERT INTO my_tab02
	SELECT * FROM emp;
SELECT * FROM my_tab02;
-- 3. 考虑去重
/* 思路
1. 先创建一张临时表 my_tmp，该表的结构和 my_tab02 一样
2. 把 my_tmp 记录，通过distinct关键字处理后，把记录复制到my_tmp;
3. 删除掉 my_tab02 记录
4. 把 my_tmp 表的记录复制到 my_tab02
*/
CREATE TABLE my_tmp LIKE my_tab02;
INSERT INTO my_tmp 
	(SELECT DISTINCT * FROM my_tab02);
-- 清除掉 my_tab02 记录
-- delete from my_tab02;
DROP TABLE my_tab02;	-- 直接删除表
RENAME TABLE my_tmp TO my_tab02; -- 再改名
SHOW TABLES;
SELECT * FROM my_tab02;
