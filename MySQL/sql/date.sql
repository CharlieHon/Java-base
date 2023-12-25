# 日期时间相关函数

SELECT CURRENT_DATE() FROM DUAL; -- 当前日期：2023-12-25
SELECT CURRENT_TIME() FROM DUAL; -- 当前时间：16:32:02
SELECT CURRENT_TIMESTAMP() FROM DUAL; -- 当前时间戳：2023-12-25 16:32:14

-- 创建测试表：信息表
CREATE TABLE mes (
	id INT,
	content VARCHAR(30),
	send_time DATETIME);
-- 添加一条记录
INSERT INTO mes VALUES (1, '北京新闻', CURRENT_TIMESTAMP());
INSERT INTO mes VALUES (2, '上海新闻', NOW());
INSERT INTO mes VALUES (3, '广州新闻', NOW());
SELECT * FROM mes;

-- 1. 显示所有新闻信息，发布日期只显示日期，不用显示时间
SELECT id, content, DATE(send_time) FROM mes;
-- 2. 查询在10分钟内发布的新闻
--				发送日期加10分钟超过现在时间，就表示发送时间是在10分钟内
SELECT * FROM mes WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW();
SELECT * FROM mes WHERE send_time >= DATE_SUB(NOW(), INTERVAL 10 MINUTE);
-- 3. 请在mysql的sql语句中求出 2011-11-11 和 1990-1-1 相差天数
SELECT DATEDIFF('2011-11-11', '1990-1-1') FROM DUAL; -- 7984
-- 4. 用sql语句求出你活了多少天
SELECT DATEDIFF(CURRENT_DATE(), '2001-3-12') FROM DUAL; -- 8323
-- 如果你能活90岁，i去除你还能活多少天
-- 思路：以出生日期加90年得到死亡日期；在计算死亡日期到今天的时间差
SELECT DATEDIFF(DATE_ADD('2001-3-12 10:15:6', INTERVAL 90 YEAR), NOW()) FROM DUAL; -- 24549
-- timediff(date1, date2) 两个时间差(多少消失多少分钟多少秒)
SELECT TIMEDIFF('16:45:00', CURRENT_TIME()) FROM DUAL;

# 年月日
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
-- unix_timestamp 返回1970-1-1 到现在的秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
-- from_unixtime() 把一个unix_timestamp秒数[时间戳]，转成指定格式的日期
-- 	在开发中，可以存放一个整数，然后表示时间，通过 from_unixtime 转换
--	在实际开发中，也经常使用 int 保存一个 unix_timestanp 时间戳
SELECT FROM_UNIXTIME(UNIX_TIMESTAMP(), '%Y-%m-%d %H:%i:%s') FROM DUAL;
