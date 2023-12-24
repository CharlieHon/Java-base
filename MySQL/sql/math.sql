# 演示数学相关函数
-- abs 绝对值
SELECT ABS(-12) FROM DUAL;
-- bin(decimal_number) 十进制转二进制

SELECT BIN(10) FROM DUAL;	-- 1010
-- hex(DecimalNumber) 转十六进制
-- conv(num1, from_base, to_base) 进制转换，从 from_base 到 to_base
--	将10进制8转为2进制 -> 1000
SELECT CONV(8, 10, 2) FROM DUAL;
-- ceiling(num) 向上取整，得到比num大的最小整数

SELECT CEILING(1.2), CEILING(-1.2) FROM DUAL;	-- -2 -1
-- floor(num) 向下取整，得到比num小的最大整数
SELECT FLOOR(1.1) FROM DUAL; -- 1

-- format(num, decimal_places) 保留小数位数(四舍五入)
SELECT FORMAT(3.1415926, 2) FROM DUAL; -- 3.14
SELECT FORMAT(3.1415926, 3) FROM DUAL; -- 3.142

-- least(num1, num2 [,...]) 求最小值
SELECT LEAST(0, -1, 10, 3) FROM DUAL;

-- mode(numerator, denominator) 求余
SELECT MOD(10, 3) FROM DUAL;	-- 1

-- rand([seed]) 返回随机数，起范围为 [0, 1]
--	如果设计随机种子，相同的随机种子每次产生值固定
SELECT RAND(2) FROM DUAL;
