# 多列子查询
-- 查询与allen的部门和岗位完全相同的所有雇员(并且不包含smithj本人)
-- (field1, field2...) = (select field1, field2 from ...)
/*
1. 得到smith的部门和岗位
2. 把上面的查询当作子查询来使用，并且使用多列子查询的语法进行匹配
*/
SELECT deptno, job FROM emp
	WHERE ename = 'allen';
SELECT * FROM emp
	WHERE (deptno, job) = (
		SELECT deptno, job 
		FROM emp
		WHERE ename = 'allen'
	) AND ename <> 'allen';
-- select * from stu
-- 	where (math, english, chinese) = (
-- 		select math, english, chinese from stu where `name` = '宋江'
-- 	) and `name` <> '宋江';
