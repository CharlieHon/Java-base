# 演示数据库操作

# 创建数据库，默认不区分大小写
CREATE DATABASE IF NOT EXISTS hsp_db01;

# 删除数据库
DROP DATABASE hsp_db01;

# 创建数据库 hsp_db02 区分大小写
CREATE DATABASE hsp_db02 CHARACTER SET utf8 COLLATE utf8_bin;

# 查询语句，select 查询 * 表示所有字段
# from 从哪个表 where 从哪个字段 name = 'tom' 查询名字是tom
SELECT * FROM t1 WHERE NAME = 'tom';
