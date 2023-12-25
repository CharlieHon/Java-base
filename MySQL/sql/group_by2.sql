# 增强 group by 的使用
SELECT * FROM emp;
-- 1. 显示每种岗位的雇员总数、平均工资
SELECT COUNT(*) FROM emp;
SELECT job, COUNT(*), FORMAT(AVG(sal), 2) FROM emp 
	GROUP BY job;
-- 2. 显示雇员总数，以及获得补助的雇员数
-- 提示：获得补助即 comm is not null;
-- count(comm)：只统计comm列非空的
SELECT COUNT(*), COUNT(comm) FROM emp;
-- 统计没有获得补助的
-- if(comm is null, 1, null); 如果comm为null，返回1(非空值即可，会统计)，否则返回 null
SELECT COUNT(*), COUNT(IF(comm IS NULL, 1, NULL)) FROM emp;
-- 3. 显示管理者的总人数
SELECT COUNT(DISTINCT mgr) FROM emp; -- 5
-- 4. 显示雇员工资的最大差额
SELECT MAX(sal) - MIN(sal) FROM emp; -- 4200

# 统计各个部分(group by)的平均工资，并且是(having)大于1000的，
-- 并且按照平均工资从高到低排序(order by)，取出前两行记录(limit)
SELECT deptno, AVG(sal) AS avg_sal 
	FROM emp 
	GROUP BY deptno 
	HAVING avg_sal > 1000 
	ORDER BY avg_sal DESC 
	LIMIT 0, 2;

-- 错误，查询列没有包含在 group by 子句中，并且这些列没有使用聚合函数(如 sum, avg等)
SELECT deptno, job FROM emp GROUP BY deptno;	
# 1. 将非聚合列添加到 group by 子句中
SELECT deptno, job FROM emp GROUP BY deptno, job;
# 2. 对非分组列使用聚合函数
SELECT deptno, COUNT(job) FROM emp GROUP BY deptno;
