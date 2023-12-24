# 演示update
ALTER TABLE employee ADD salary DOUBLE NOT NULL DEFAULT 1000 AFTER job;
DESC employee;
SELECT * FROM employee;
INSERT INTO employee VALUES 
	(110, '小妖怪', '1997-10-06', '巡视员', 800, '2021-03-12 10:00:00', '巡逻', '大王叫我来巡山');
-- 1. 将所有员工的薪水修改为 5000元
UPDATE employee SET salary = 5000;	# 如果没有带 where 条件，会修改所有的记录，因此需要谨慎
-- 2. 将姓名为小妖怪的员工薪水修改为3000
UPDATE employee SET salary = 3000 WHERE user_name = '小妖怪';
-- 3. 将李自成的薪水在原有基础上增加1000元
UPDATE employee SET salary = salary + 1000 WHERE user_name = '李自成';
-- 4. update可以修改多个列，中间使用 , 分隔
UPDATE employee SET salary = salary + 1000, job = '起义' WHERE user_name = '李自成';

# 使用细节
/*
1. update语法可以用新值更新原有表中的各列
2. set子句指示要修改哪些列和要给予哪些值
3. where子句指定应更新哪些行。如果没有where，则更新所有行(记录)，因此需要谨慎
4. 如果需要修改多个字段，可以通过 set filed1 = value1, field2 = value2...
*/
