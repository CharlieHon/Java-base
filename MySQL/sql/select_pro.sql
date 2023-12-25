-- 查询加强
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

-- 1. 查询1992.1.1后入职的员工
-- 	在mysql中，日期类型数据可以直接比较
SELECT * FROM emp WHERE hiredate > '1992-1-1';
-- 2. 使用 like 操作符(模糊)查询
--	%：表示0到多个字符
--	_：表示单个任意字符
# 查询首字母为S的员工姓名和工资
SELECT ename, sal FROM emp WHERE ename LIKE 'S%';
# 查询第三个字符为大写o的所有员工的姓名和工资
SELECT ename, sal FROM emp WHERE ename LIKE '__O%';

# 查询没有上级的雇员情况
SELECT * FROM emp WHERE mgr IS NULL;
# 查询表结构
DESC emp;

# order by
-- 按照工资从低到高的顺序[升序] 显示雇员信息
SELECT * FROM emp ORDER BY sal ASC;
-- 按照部分号升序而雇员工资降序排序，显示员工信息
SELECT * FROM emp ORDER BY deptno ASC, sal DESC;
