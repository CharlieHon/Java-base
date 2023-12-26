# 子查询演示
-- 显示与SMITH同一个部分的所有员工
/*
1. 先查询到SMITH的部门号
2. 把上面的select语句当作一个子查询来使用
*/
SELECT deptno 
	FROM emp
	WHERE ename = 'SMITH';
-- 单行子查询
SELECT * FROM emp
	WHERE deptno = (
	SELECT deptno 
		FROM emp
		WHERE ename = 'SMITH'	
	);
-- 查询和部门10的工作相同的雇员的名字、岗位、工资、部门号，但是不含10号部门自己的员工
/*
1. 查询10号部门有哪些工作
2. 把上面查询的结果当作子查询使用
*/
SELECT DISTINCT job FROM emp WHERE deptno = 10; # 10号部门的工作
-- 多行子查询：IN
SELECT ename, job, sal, deptno 
	FROM emp
	WHERE job IN (SELECT DISTINCT job FROM emp WHERE deptno = 10)
		AND deptno <> 10;

-- 查询每个部门高于该部门平均工资的员工
# 将子查询的结果作为一张新表，可以解决很多很多问题
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno; -- 查询每个部门的员工平均工资
SELECT ename, job, sal, emp.deptno, avg_sal
	FROM emp, (SELECT deptno, AVG(sal) AS avg_sal FROM emp GROUP BY deptno) temp -- 新表别名 temp
	WHERE emp.deptno = temp.deptno AND emp.sal > temp.avg_sal;
