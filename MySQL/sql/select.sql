# select 语句[重点，难点]
CREATE TABLE student (
	id INT NOT NULL DEFAULT 1,
	`name` VARCHAR(20) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0
	);

INSERT INTO student (id, `name`, chinese, english, math) VALUES 
	(1, '王熙凤', 78, 65, 89),
	(2, '妙玉', 85, 70, 76),
	(3, '薛宝钗', 100, 80, 97),
	(4, '贾宝玉', 90, 70, 80),
	(5, '林黛玉', 100, 85, 96),
	(6, '史湘云', 93, 70, 82),
	(7, '贾探春', 90, 85, 86);


-- 1. 查询表中所有学生信息
SELECT * FROM student;
-- 2. 查询表中所有学生的姓名和对应的语文成绩
SELECT `name`, chinese FROM student;
-- 3. 过滤表中重复数据
SELECT DISTINCT english FROM student;	# 去掉 english 成绩重复的数据
-- 4. 要查询的记录，每个字段都相同，才会去重
SELECT DISTINCT `name`, chinese FROM student;	# 虽然语文成绩相同，但是姓名都不同，不会被去重

# 使用表达式对查询的列进行运算
-- 1. 统计每个学生的总分
SELECT `name`, (chinese + english + math) FROM student;
-- 2. 在所有学生总分上加10分，设置别名表示 name 和 总分成绩
SELECT `name` AS '姓名', (chinese + english + math + 10) AS '总分' FROM student;


# 使用where子句，进行过滤查询
-- 1. 查询姓名为林黛玉的学生成绩
SELECT * FROM student WHERE `name` = '林黛玉';
-- 2. 查询语文成绩大于90分的同学
SELECT * FROM student WHERE chinese > 90;
-- 3. 查询总分大于260分的所有同学
SELECT * FROM student WHERE (chinese+english+math) > 260;
-- 4. 查询数学大于60并且语文大于85的学生成绩
SELECT * FROM student WHERE math > 60 AND chinese > 85;
-- 5. 查询数学成绩大于语文成绩的同学
SELECT * FROM student WHERE math > chinese;
-- 6. 查询总分大于240分 并且 数学成绩小于语文成绩的姓贾的学生
--	'林%' 表示 名字中以林开头就可以
SELECT *, (chinese+math+english) AS total_score FROM student 
	WHERE (math+chinese+english) > 240 AND math < chinese AND `name` LIKE '林%';

# 查询语文成绩在80~90之间的学生	between and 是闭区间[]
SELECT * FROM student WHERE chinese BETWEEN 80 AND 90;
# 查询数学分数为 89,90,91 的同学
SELECT * FROM student WHERE math IN (89, 90, 91);
# 查询所有姓贾的学生成绩
SELECT * FROM student WHERE `name` LIKE '贾%';
# 查询数学>80 或 语文>90的学生
SELECT * FROM student WHERE math > 80 OR chinese > 90;


## order by 子句排序查询
-- 1. 对语文成绩排序后输出[升序]
SELECT * FROM student ORDER BY chinese ASC;	-- 默认即升序
-- 2. 对总分按从高到低的顺序输出
SELECT `name`, (chinese + math + english) AS total_score FROM student 
	ORDER BY total_score DESC;	-- 使用别名排序
-- 3. 对姓贾的学生成绩排序输出(升序)
SELECT `name`, (chinese+math+english) AS total_score FROM student 
	WHERE `name` LIKE '贾%' ORDER BY total_score ASC;	-- 起别名后，排序也可以按照 (chinese+...)来
