# 合并查询
SELECT ename, job FROM emp WHERE sal > 2500;
SELECT ename, sal, job FROM emp WHERE job = 'MANAGER';
-- 1. union all 就是将两个查询结果合并，不会去重
SELECT ename, sal, job FROM emp WHERE sal > 2500 UNION ALL
	SELECT ename, sal, job FROM emp WHERE job = 'MANAGER';
-- 2. union 效果同上，但会去重
SELECT ename, sal, job FROM emp WHERE sal > 2500 UNION
	SELECT ename, sal, job FROM emp WHERE job = 'MANAGER';
