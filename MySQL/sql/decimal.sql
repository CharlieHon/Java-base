# 演示decimal类型、float、double使用

# 创建表
CREATE TABLE t5 (
	num1 FLOAT,
	num2 DOUBLE,
	num3 DECIMAL(30, 20));	# 30位长，20个小数位
# 添加数据
INSERT INTO t5 VALUES (88.12345678912345, 88.12345678912345, 88.12345678912345);
SELECT * FROM t5;
