# 视图练习
-- 针对emp,dept和salgrade三张表，创建一个视图 emp_view03
-- 可以显示雇员编号，雇员名，雇员部门名称和薪水级别
SELECT DISTINCT empno, ename, dname, grade FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND (sal BETWEEN losal AND hisal);
-- 将得到的表，构建成视图
CREATE VIEW my_emp03 AS
	SELECT DISTINCT empno, ename, dname, grade FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND (sal BETWEEN losal AND hisal);
SELECT * FROM my_emp03;
