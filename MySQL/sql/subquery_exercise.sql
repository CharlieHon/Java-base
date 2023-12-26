# 子查询练习
-- 1. 查询每个部门工资高于本部门平均工资的人的资料
SELECT AVG(sal) FROM emp 
	GROUP BY deptno;
SELECT  emp.deptno, ename, sal, temp.avg_sal
	FROM emp, (SELECT deptno, AVG(sal) AS avg_sal FROM emp GROUP BY deptno) AS temp
	WHERE emp.deptno = temp.deptno AND emp.sal > avg_sal;
-- 2. 查找每个部门工资最高的人的详细资料
SELECT ename, job, sal, emp.deptno, max_sal
	FROM emp, (SELECT deptno, MAX(sal) AS max_sal FROM emp GROUP BY deptno) AS tmp
	WHERE emp.deptno = tmp.deptno AND emp.sal = tmp.max_sal;
-- 3. 查询每个部门的信息(包括：部门名、编号、地址)和人员数量
/*
1. 部门名、编号、地址 来自 dept表
2. 各个部门的人员数量 -> 构架一个临时表
*/
SELECT deptno, COUNT(*) FROM emp GROUP BY deptno; -- 按deptnp分组，查询到每个部门的人数
SELECT  dept.deptno, dname, loc, emp_num AS '人数'
	FROM dept, (SELECT deptno, COUNT(*) AS emp_num FROM emp GROUP BY deptno) AS tmp
	WHERE dept.deptno = tmp.deptno;
-- 还有一种写法：dept.* 表示将该表所有列都显示出来
-- 在多表查询时，当多个表的列不重复时，才可以直接写列名
SELECT  dept.*, emp_num AS '人数'
	FROM dept, (SELECT deptno, COUNT(*) AS emp_num FROM emp GROUP BY deptno) AS tmp
	WHERE dept.deptno = tmp.deptno;
