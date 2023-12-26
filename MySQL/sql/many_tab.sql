# 多表查询
-- 查询雇员名、雇员工资及所在部门的名字
/*
1. 雇员名、雇员工资 来自 emp 表
2. 部门名字 来自 dept 表
3. 需求对 emp 和 depy 查询
4. 当需要指定显示莫格表的某列时，需要使用：表.列名
5. 提示：多表查询的条件不能少于 表的个数-1，否则会出现笛卡尔积
*/
SELECT * FROM emp, dept;
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

SELECT ename, sal, dname FROM emp, dept 
	WHERE emp.deptno = dept.deptno;
-- 查询部门号为10的部门名、员工名和工资
SELECT dname, ename, sal FROM emp, dept
	WHERE emp.deptno = dept.deptno AND emp.deptno = 10;
-- 显示各个员工的姓名、工资及其工资的级别
SELECT ename, sal, grade
	FROM emp, salgrade -- 也可以不加表名，因为两表无相同列名
	WHERE emp.sal BETWEEN salgrade.losal AND salgrade.hisal;
-- 显示雇员名、雇员工资及所在部门的名字，并按部门排序[降序排]
SELECT ename, sal, dname
	FROM emp, dept
	WHERE emp.deptno = dept.deptno
	ORDER BY emp.deptno DESC;
