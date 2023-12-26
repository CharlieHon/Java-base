# 外连接
-- 列出部分名称和这些部门的员工名称和工作，要求同时显示出那些没有员工的部门
SELECT dname, ename, job FROM emp, dept
	WHERE emp.deptno = dept.deptno; -- 这个无法查到没有员工的部门

-- 创建 stu
CREATE TABLE stu (
	id INT,
	`name` VARCHAR(32)
);
INSERT INTO stu VALUES (1, 'jack'), (2, 'tom'), (3, 'kiki'), (4, 'vivo');
SELECT * FROM stu;
/* 创建 exam
id grade
1 56
2 76
*/
CREATE TABLE exam (
	id INT,
	grade INT
);
INSERT INTO exam VALUES (1, 56), (2, 76), (11, 8);
SELECT * FROM exam;
-- 1. 使用左连接，显示所有人的成绩，如果没有成绩，也要显示该人的姓名和id号
SELECT `name`, stu.id, grade FROM stu, exam
	WHERE stu.id = exam.id; -- 只会取两张表的交集部分
-- 改为外连接
SELECT `name`, stu.id, grade
	FROM stu LEFT JOIN exam
	ON stu.id = exam.id;
-- 2. 使用右连接，显示所有成绩，如果没有匹配的名字，就显示空
-- 即：右边的表exam和坐标没有匹配的记录，也会把右表的记录显示出来
SELECT  stu.id, `name`, grade
	FROM stu RIGHT JOIN exam
	ON stu.id = exam.id;
# 显示部门名称和部门的员工信息(名字和工作)，同时列出那些没有员工的部门
/* 分析
1. 同时显示那些没有员工的部门，即要求部门信息全部显示
*/
SELECT dname, ename, job FROM emp RIGHT JOIN dept
	ON emp.deptno = dept.deptno; -- 右外连接
SELECT dname, ename, job FROM dept LEFT JOIN emp
	ON dept.deptno = emp.deptno; -- 左外连接
