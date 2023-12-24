# delete 语句演示
SELECT * FROM employee;
-- 删除表中名称为小妖怪的记录
DELETE FROM employee 
	WHERE user_name = '小妖怪';

# delete使用细节
-- 1. 如果不适用where子句，将删除表中所有数据
DELETE FROM employee;
-- 2. delete语句不能删除某一列的值(可使用update设置为null或者'')
UPDATE employee SET job = '' WHERE user_name = '李自成';
-- 3. 使用delete语句仅删除记录，不删除表本身。如果要删除表，使用 drop table 表名;
DROP TABLE employee;
