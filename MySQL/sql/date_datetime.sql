# 演示事件相关的类型
# 创建一张表
CREATE TABLE t9 (
	birthday DATE,	-- 生日
	jobtime DATETIME, -- 记录年月日 时分秒
	login_time TIMESTAMP
		NOT NULL			-- 非空
		DEFAULT CURRENT_TIMESTAMP 	-- 默认当前时间
		ON UPDATE CURRENT_TIMESTAMP	-- 更新时更新为当前时间
	);
SELECT * FROM t9;
INSERT INTO t9(birthday, jobtime) 
	VALUES ('2023-12-23', '2023-12-23 19:25:30');
-- 如果更新 t9表的某条记录，login_time列会自动的以当前时间进行更新
