# 多表查询：自连接
-- 显示公司公司员工和他的上级的名字
/*
员工名字和其上级名字都在 emp
员工和上级是通过 dept 的 mgr列关联的
1. 把同一张表当作两张表使用
2. 需要给表取别名： from 表名 表别名
3. 如果列名不明确，可以指定列的别名： 列名 as 列别名
*/
SELECT worker.ename AS '职员名', boss.ename AS '上级名' 
	FROM emp AS worker, emp boss	-- 自连接需要设置别名，否则会报错
	WHERE worker.mgr = boss.empno;
