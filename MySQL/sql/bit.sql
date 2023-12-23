# 演示 bit类型 使用
/* 说明
1. bit(m) m范围1~64
2. 添加数据 范围按照给定的 位数 确定，比如m=8，表示一个字节 0~255
3. 显示按照的bit，即二进制格式
4. 查询时，仍然可以按照数来查询
*/
CREATE TABLE t4 (num BIT(8));	# 8位，范围0~255
INSERT INTO t4 VALUES(255);	# b'11111111'
SELECT * FROM t4;
SELECT * FROM t4 WHERE num = 255;
