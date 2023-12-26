# 在多行子拆线呢中使用all和any操作符
-- 显示工资比部门30的所有员工的工资高的员工的姓名、工资和部门号
SELECT MAX(sal) FROM emp WHERE deptno = 30;
-- 使用 max
SELECT ename, sal, deptno FROM emp WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);
-- 使用 all操作符
SELECT ename, sal, deptno FROM emp WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);
-- 显示比30号部门其中的一个员工的工资高的员工的姓名、工资和部门号
-- 可以使用 any 也可以使用 min
SELECT ename, sal, deptno FROM emp WHERE sal > ANY(SELECT sal FROM emp WHERE deptno = 30);
