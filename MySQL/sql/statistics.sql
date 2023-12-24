# 演示mysql的统计函数的使用
-- 1. 统计一个班级中有多少学生
SELECT COUNT(*) FROM student;
-- 2. 统计语文大于90的学生人数
SELECT COUNT(*) FROM student WHERE chinese > 90;
-- 3. 统计总分大于250的人数
SELECT COUNT(*) FROM student WHERE (chinese+math+english) > 250;

/* count(*) 和 count(列名) 的区别
-- count(*)：返回满足条件的记录的行数
-- ocunt(列名)：统计满足条件的某列有多少个，但是会排序值为 NULL 的
*/
CREATE TABLE t1 (
	`name` VARCHAR(10));
INSERT INTO t1 VALUES ('tom'), ('jack'), (NULL);
SELECT * FROM t1;
SELECT COUNT(*), COUNT(`name`) FROM t1;	-- 3 2

# 演示sum函数的使用
-- 统计班级数学总成绩
SELECT SUM(math) FROM student;
-- 统计班级各科的总成绩
SELECT SUM(math), SUM(english), SUM(chinese) FROM student;
-- 统计班级总成绩的和
SELECT SUM(chinese+math+english) FROM student;
-- 统计一个班级语文的平均成绩
SELECT SUM(chinese) / COUNT(*) FROM student;

# 演示 avg 的使用
-- 求班级语文平均分
SELECT AVG(chinese) FROM student;
-- 求班级总成绩平均分
SELECT AVG(chinese+math+english), SUM(chinese+math+english)/COUNT(*) FROM student;

# 演示 max/min 使用
-- 求班级总分的最高分和最低分
SELECT MAX(math+chinese+english), MIN(chinese+math+english) FROM student;
-- 求出班级语文最高分和最低分
SELECT MAX(chinese), MIN(chinese) FROM student;
