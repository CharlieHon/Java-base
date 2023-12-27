# hsp用户
SELECT USER();
-- 在默认情况下，hsp用户只能看到一个默认的系统数据库
SHOW DATABASES;
USE testdb;
SHOW TABLES;
SELECT * FROM news;
INSERT INTO news VALUES (200, '人民日报');

-- 能否修改，能否delete
UPDATE news SET `name` = '北京新闻' WHERE id = 200; -- 无权限
DELETE FROM news WHERE id = 200; -- 无权限
