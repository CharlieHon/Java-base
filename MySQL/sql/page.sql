# 分页查询
-- 按照雇员id号升序取出，每页显示3条记录，请分别显示 第1页 第2页 第3页
-- 基本语法：select ... from table_name order by field1 asc limit start, rows;
--	表示从 start+1 行开始取，取出 rows 行，start 从0开始计算
-- 推导公式：limit (页数-1)*行数, 行数
SELECT * FROM emp;
-- 第1页
SELECT * FROM emp 
	ORDER BY empno
	LIMIT 0, 3;
-- 第2页
SELECT * FROM emp 
	ORDER BY empno
	LIMIT 3, 3;
-- 第3页
SELECT * FROM emp 
	ORDER BY empno
	LIMIT 6, 3;
-- 第5页
SELECT * FROM emp ORDER BY empno LIMIT 12, 3;

-- 练习：按照雇员empno号降序取出，每页显示5条记录。请分别显示 第3页 第5页 对应sql语句
SELECT * FROM emp ORDER BY empno DESC LIMIT 10, 5;
SELECT * FROM emp ORDER BY empno DESC LIMIT 20, 5;
