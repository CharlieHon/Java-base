# Mysql练习1
USE db01;
SHOW TABLES;
#################################### homework01
-- 1. 别名为两个单词时，需要使用引号 '' 括起来
SELECT ename, sal*12 'Annual Salary' FROM emp;
-- 2. 显示补助非空的雇员：判断是否非空用 is [not]
SELECT * FROM emp WHERE comm IS NOT NULL;


#################################### homework02
-- 3. 查看表结构
DESC dept;
DESC emp;
-- 4. 显示所有部分的名称
SELECT dname FROM dept;
-- -- 仅显示有人的部门的名称
-- SELECT DISTINCT dname FROM emp, dept WHERE emp.deptno = dept.deptno;
-- -- 显示所有部门的名称
-- SELECT DISTINCT dname FROM emp RIGHT JOIN dept ON emp.deptno = dept.deptno;

-- 5. 显示所有雇员名及其年收入 13月(工资+补助)
SELECT ename, (sal + IFNULL(comm, 0)) * 13 AS 'Annual Salary' FROM emp;
-- 6. 限制查询
SELECT ename, sal FROM emp WHERE sal > 2850;
SELECT ename, sal FROM emp WHERE NOT (sal BETWEEN 1500 AND 2850);
SELECT ename, deptno FROM emp WHERE empno = 7566;
SELECT ename, sal FROM emp WHERE deptno IN (10, 30) AND sal > 1500;
SELECT ename, job FROM emp WHERE mgr IS NULL;
-- 7. 排序数据
SELECT ename, job, hiredate FROM emp WHERE hiredate BETWEEN '1991-2-1' AND '1991-5-1' ORDER BY hiredate;
SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL ORDER BY sal DESC;


#################################### homework03
# 根据emp表，写出正确SQL
SELECT * FROM emp WHERE deptno = 30;
SELECT ename, empno, deptno FROM emp WHERE job = 'CLERK';
SELECT * FROM emp WHERE IFNULL(comm, 0) > sal;
SELECT * FROM emp WHERE comm > (sal * 0.6);
SELECT * FROM emp WHERE 
	(deptno = 10 AND job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK');
-- select * from emp where deptno = 20 AND job = 'CLERK'; # 无
SELECT * FROM emp WHERE 
	(deptno = 10 AND job = 'MANAGER') OR 
	(deptno = 20 AND job = 'CLERK') OR
	(job NOT IN ('MANAGER', 'CLERK') AND sal >= 2000);
SELECT DISTINCT job FROM emp WHERE comm IS NOT NULL; -- salesman
SELECT * FROM emp WHERE comm IS NULL OR comm < 100;

# 找出各月倒数第3天受雇的所有员工
-- select * from emp 	-- 加2天，还在本月；加3天，到下一月
-- 	where month(DATE_ADD(hiredate, INTERVAL 2 DAY)) = month(hiredate) and 
-- 	MONTH(DATE_ADD(hiredate, INTERVAL 3 DAY)) = (MONTH(hiredate)+1) % 12; -- % 取余

/*****************  LAST_DAY 返回该日期所在月份的最后一天               ********************/
SELECT LAST_DAY('2023-12-28');
SELECT * FROM emp WHERE DATE_ADD(hiredate, INTERVAL 2 DAY) = LAST_DAY(hiredate);

# 找出早于30年前受雇的员工
SELECT * FROM emp WHERE DATE_ADD(hiredate, INTERVAL 30 YEAR) <= CURRENT_DATE();
# 以首字母小写的方式显示所有员工的姓名
SELECT CONCAT(LCASE(LEFT(ename, 1)), SUBSTRING(ename, 2)) FROM emp;
# 显示正好为5个字符的员工的姓名
SELECT * FROM emp WHERE LENGTH(ename) = 5;
# 显示不带有 R 的员工的姓名
SELECT * FROM emp WHERE ename NOT LIKE '%R%';
# 显示所有员工姓名的前三个字符
SELECT LEFT(ename, 3) FROM emp;
# 显示所有员工的姓名，用 a 替换所有 A
SELECT REPLACE(ename, 'A', 'a') FROM emp;
# 显示满32年服务年限的员工的姓名和受雇日期
SELECT ename, hiredate FROM emp WHERE DATE_ADD(hiredate, INTERVAL 32 YEAR) <= NOW();
# 显示员工的详细资料，按姓名排序
SELECT * FROM emp ORDER BY ename;
SELECT ename, hiredate FROM emp ORDER BY hiredate ASC;
# 显示所有员工的姓名、工作和薪金，按工作降序排序，若工作相同则按薪金排序
SELECT ename, job, sal FROM emp ORDER BY job DESC, sal ASC;
SELECT ename, CONCAT(YEAR(hiredate), '-', MONTH(hiredate)) AS tmp FROM emp ORDER BY MONTH(hiredate), YEAR(hiredate);
SELECT ename, ROUND(sal / 30) FROM emp; -- 日薪
# 2月分受聘的员工
SELECT * FROM emp WHERE MONTH(hiredate) = 2;
# 对于每个员工显示其入职的天数
SELECT ename, DATEDIFF(CURRENT_DATE(), hiredate) FROM emp;
SELECT ename FROM emp WHERE ename LIKE '%A%';
-- 以年月日的方式显示所有员工的服务年限
SELECT ename, FLOOR(DATEDIFF(NOW(), hiredate) / 365) AS '工作年', FLOOR(DATEDIFF(NOW(), hiredate) % 365 / 31) AS '工作月',
		FLOOR(DATEDIFF(NOW(), hiredate) % 31) AS '工作天' FROM emp;
-- select ename, from_unixtime(DATEDIFF(CURRENT_DATE(), hiredate)*24*60*60, '%Y-%m-%d') from emp;
-- select unix_timestamp() from dual;


#################################### homework04
-- 列出至少有一个员工的所有部门
-- select distinct emp.deptno, dname from emp, dept where emp.deptno = dept.deptno;
SELECT COUNT(*) AS c, deptno FROM emp GROUP BY deptno HAVING c > 1;
-- 列出薪金比 SMITH 多的所有员工
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'SMITH');


-- 列出受雇日期晚于其直接上级的所有员工
/*
	先把emp表当作两张表 ---> 自连接
*/
SELECT worker.ename AS '员工名', worker.hiredate AS '员工入职时间',
	leader.ename AS '上级名', leader.hiredate AS '员工入职时间'
	FROM emp worker, emp leader WHERE worker.mgr = leader.empno AND worker.hiredate > leader.hiredate;
-- select * from emp as a where mgr is not null and 
-- 	hiredate > (select hiredate from emp where empno = a.mgr);


-- 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门
SELECT dname, emp.* FROM emp RIGHT JOIN dept ON emp.deptno = dept.deptno ORDER BY dname;
-- 列出所有 CLERK 的姓名及其部门名称
-- select * from emp where job = 'CLERK';
SELECT ename, dname FROM emp, dept WHERE emp.deptno = dept.deptno AND job = 'CLERK';
-- 列出最低薪金大于1500的各种工作
SELECT job FROM emp GROUP BY job HAVING MIN(sal) > 1500;
-- 列出部门 SALES 工作的员工的姓名
SELECT ename FROM emp WHERE deptno = (SELECT deptno FROM dept WHERE dname = 'SALES');
-- 列出薪金高于公司平均薪金的所有员工
SELECT * FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);
-- 列出与 SCOTT 从事相同工作的所有员工
SELECT * FROM emp WHERE job = (SELECT job FROM emp WHERE ename = 'SCOTT');
-- 列出薪金高于所在部门30工作的所有员工的薪金的员工姓名和薪金
SELECT ename, sal FROM emp WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);
SELECT deptno, COUNT(*) AS `emp_num`, AVG(sal), FORMAT(AVG(DATEDIFF(NOW(), hiredate) / 365), 2) AS `work_yeas` FROM emp GROUP BY deptno;
SELECT ename, dname, sal FROM emp LEFT JOIN dept ON emp.deptno = dept.deptno;

-- 13
SELECT deptno, COUNT(*) AS c FROM emp GROUP BY deptno;
SELECT dept.*, tmp.c FROM dept, (SELECT deptno, COUNT(*) AS c FROM emp GROUP BY deptno) tmp
	WHERE dept.deptno = tmp.deptno;
-- select dname, count(*) from (SELECT dept.deptno, dname, loc FROM dept LEFT JOIN emp ON dept.deptno = emp.deptno) as tmp
-- 	group by dname;

-- 14
SELECT job, MIN(sal) FROM emp GROUP BY job;
-- 15
SELECT MIN(sal) FROM emp WHERE job = 'MANAGER';
-- 16
SELECT ename, (sal + IFNULL(comm, 0)) * 12 AS year_sal 
	FROM emp ORDER BY year_sal ASC;


#################################### homework05
CREATE TABLE department (
	departmentid VARCHAR(32) PRIMARY KEY,
	deptname VARCHAR(16) UNIQUE NOT NULL
);
INSERT INTO department VALUES ('001', '数学'), ('002', '计算机'), ('003', '化学'),
	('004', '中文'), ('005', '经济');
CREATE TABLE class (
	classid INT PRIMARY KEY,
	`subject` VARCHAR(16) NOT NULL DEFAULT '',
	deptname VARCHAR(16),	-- 外键字段，在表定义后指定
	enrolltime INT NOT NULL DEFAULT 2019,
	num INT UNSIGNED NOT NULL DEFAULT 0,
	FOREIGN KEY (deptname) REFERENCES department(deptname)
);

INSERT INTO class VALUES
	(101, '软件', '计算机', 1995, 20),
	(102, '微电子', '计算机', 1996, 30),
	(111, '无机化学', '化学', 1995, 29),
	(112, '高分子化学', '化学', 1996, 25),
	(121, '统计数学', '数学', 1995, 20),
	(131, '现代语言', '中文', 1996, 20),
	(141, '国际贸易', '经济', 1997, 30),
	(142, '国际金融', '经济', 1996, 14);

CREATE TABLE student2 (
	studentid INT PRIMARY KEY,
	`name` VARCHAR(16) NOT NULL DEFAULT '',
	age INT NOT NULL DEFAULT 18,
	classid INT, -- 外键
	FOREIGN KEY (classid) REFERENCES `class`(classid)
);

INSERT INTO student2 VALUES
	(8101, '丁义珍', 18, 101),
	(8102, '钟小艾', 16, 121),
	(8103, '郑乾', 17, 131),
	(8105, '陈岩石', 19, 102),
	(8109, '赵立春', 18, 141),
	(8110, '高育良', 20, 142),
	(8201, '李达康', 18, 111),
	(8302, '赵东来', 16, 112),
	(8203, '祁同伟', 17, 111),
	(8305, '侯亮平', 19, 102),
	(8409, '沙瑞金', 18, 101),
	(8510, '田国富', 20, 142);
SELECT * FROM student2;
-- 3.1
SELECT * FROM student2 WHERE `name` LIKE '李%';
-- 3.2
SELECT deptname FROM class GROUP BY deptname HAVING COUNT(*) > 1;
-- 3.3
-- select departmentid, class.deptname from class, department where class.deptname = department.deptname and num >= 30;
-- 1. 先查系人数，并过滤得到大于等于30人数的系
SELECT deptname, SUM(num) AS nums FROM class GROUP BY deptname HAVING nums >= 30;
-- 2. 联合查询
SELECT * FROM department, (SELECT deptname, SUM(num) AS nums FROM class GROUP BY deptname HAVING nums >= 30) tmp
	WHERE department.deptname = tmp.deptname;
-- 4
INSERT INTO department VALUES ('006', '物理');
-- 5 赵立春退学，请更新相关表
/*
 所在班级人数 -1
 从学生表中删除
*/
-- 开启事务
START TRANSACTION;
UPDATE class SET num = num - 1 
	WHERE classid = (SELECT classid FROM student2 WHERE `name` = '赵立春');
DELETE FROM student WHERE `name` = '赵立春';
COMMIT;
SELECT * FROM student2;
SELECT * FROM class;
