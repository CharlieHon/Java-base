# 演示整型使用
# 说明：表的字符集、校验规则、存储引擎使用默认
# 1. 如果没有指定 unsigned ，则默认数值类型都为有符号类型
# 2. 以 tinyint 为例，有符号范围 -128~127 无符号 0~255
CREATE TABLE t2 (
	id TINYINT);
CREATE TABLE t3 (
	id TINYINT UNSIGNED);	# 无符号类型

INSERT INTO t2 VALUES(-128);	# 添加语句
SELECT * FROM t2;

INSERT INTO t3 VALUES(255);
SELECT * FROM t3;
