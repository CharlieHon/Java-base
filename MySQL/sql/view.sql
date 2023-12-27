# 视图的使用
-- 创建一个视图 emp_view01
CREATE VIEW emp_view01 AS 
	SELECT empno, ename, job, deptno FROM emp;
-- 查看视图
DESC emp_view01;
SELECT * FROM emp_view01;
-- 修改视图
-- alter view emp_view01 as select ...; -- 更新成新的视图
-- 查看创建视图的指令
SHOW CREATE VIEW emp_view01;
-- 删除视图
DROP VIEW emp_view01;

# 视图的细节讨论
-- 1. 创建视图后，到数据库查看，对应视图只有一个视图结构文件(形式：视图名.frm)
-- 2. 视图的数据变化会影响到基表，同时基表数据的变化也会影响到视图
UPDATE emp_view01 SET job = 'MANAGER' WHERE empno = 7369;
SELECT * FROM emp WHERE empno = 7369;
UPDATE emp SET job = 'SALESMAN' WHERE empno = 7369;
SELECT * FROM emp_view01 WHERE empno = 7369;
-- 3. 视图中可以再使用视图，比如从 emp_view01 视图中，选出 empno 和 ename 做出新视图
CREATE VIEW emp_view02 AS SELECT empno, ename FROM emp_view01;
SELECT * FROM emp_view02;
