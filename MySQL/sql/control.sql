# 演示流程控制语句
-- if(expr1, expr2, expr3) 如果表达式1为True，则返回expr2，否则返回expr3
SELECT IF(TRUE, '北京', '上海') FROM DUAL;
-- inull(expr1, expr2) 如果1不为空NULL，则返回expr1，否则返回expr2
SELECT IFNULL(NULL, 'hsp'); -- hsp
-- select case where expr1 then expr2 when expr3 then expr4 end;
SELECT CASE WHEN TRUE THEN 'jack' WHEN FALSE THEN 'tom' ELSE 'smith' END;

-- 1. 查询emp表，如果comm为null，则显示0.0
-- 		强调：判断是否为null，要用 is / is not
SELECT ename, IF(comm IS NULL, 0.0, comm) FROM emp;
-- 2. 如果emp表的job是 clerk 则显示职员，如果是 manager 则显示经理，如果是 SALESMAN 则显示销售人员
-- select charset(job) from emp; -- utf8
SELECT ename, 
	(SELECT CASE WHEN job='clerk' THEN '职员' 
		WHEN job='manager' THEN '经理' 
		WHEN job='salesman' THEN '销售人员'
		ELSE job END) AS 'career', job 
	FROM emp;
