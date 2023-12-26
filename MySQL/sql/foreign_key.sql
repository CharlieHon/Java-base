# 外键约束
-- 创建主表 my_class 
CREATE TABLE my_class (
	id INT PRIMARY KEY, -- 班级编号
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);
-- 创建从表 my_stu
CREATE TABLE my_stu (
	id INT PRIMARY KEY, -- 学生编号
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	class_id INT, -- 学生所在班级编号
	-- 下面指定外键关系
	FOREIGN KEY(class_id) REFERENCES my_class(id)
);
-- 测试数据
INSERT INTO my_class VALUES (100, 'Java'), (200, 'Web');
SELECT * FROM my_class;
INSERT INTO my_stu VALUES (1, 'jack', 100), (2, 'charlie', 200);
SELECT * FROM my_stu;
INSERT INTO my_stu VALUES (3, 'hsp', 300); # 失败，因为300班级不存在
INSERT INTO my_stu VALUES (4, 'lzc', NULL); # 外键的值可以为null，前提是外键允许为空
-- 一旦建立外键的关系，数据不能随意删除了
DELETE FROM my_class WHERE id = 100; # 错误，my_stu表有外键指向它
