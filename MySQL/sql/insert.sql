-- 练习insert语句
SELECT DATABASE();
USE db01;

CREATE TABLE `goods` (
	id INT,
	good_name VARCHAR(10),
	price DOUBLE);

-- 添加数据
INSERT INTO goods (id, good_name, price)
	VALUES(10, 'HUAWEI', 2000);
INSERT INTO goods (id, good_name, price)
	VALUES(12, 'APPLE', 3600);
SELECT * FROM goods;


# insert语句的细节
-- 1. 插入的数据应与字段的数据类型相同。如把 'abc' 添加到 int 类型会报错
-- 	如把 '30' 添加到 int类型中，会尝试类型转换，可以进行
INSERT INTO goods (id, good_name, price)
	VALUES ('30', 'MI', 1800);
-- 2. 数据的长度应在列的规定范围内，例如：不能将一个长度为80的字符串加入到长度为40的列中
-- 3. 在values中列出的数据位置必须与被加入的列的排列位置相对应
-- 4. 字符和日期型数据应包含在单引号中
/*insert into goods (id, good_name, price)
	values (40, VIVO, 2200);
*/
-- 5. 列可以插入空值(前提是该字段允许为空，默认可以为空)
INSERT INTO goods (id, good_name, price)
	VALUES (40, 'vivo', NULL);
-- 6. insert into tab_name (列名...) values (), (), () 形式添加多条记录
INSERT INTO goods (id, good_name, price)
	VALUES (50, 'oppo', 1900), (60, 'SAM', 3200);
-- 7. 如果是给表中的所有字段添加数据，可以不写前面字段名称
INSERT INTO goods VALUES (70, 'X', 3000);
-- 8. 默认值的使用，当不给某个字段值时，如果有默认值就会添加默认值，否则报错
--	如果某列没有指定 not null 那么当添加数据时，没有给定值，则会默认为null
-- 	如果希望指定某个列的默认值，可以在创建表时指定 default
INSERT INTO goods (id, good_name)
	VALUES (80, '格力手机');
