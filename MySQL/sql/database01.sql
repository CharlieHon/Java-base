# 显示所有数据库
SHOW DATABASES;
# 查询当前所在数据库
SELECT DATABASE();
# 创建数据库
CREATE DATABASE IF NOT EXISTS db01 CHARACTER SET utf8 COLLATE utf8_general_ci;
# 查看指定数据库创建语句
SHOW CREATE DATABASE db01;
# 删除指定数据库
DROP DATABASE IF EXISTS db01;
# 备份数据库，dos> 表示在dos命令行下运行该指令
# dos> mysqldump -u root -p -B db03 hsp_db02 > d:\\bak.sql
# 备份数据库中的表
# dos> mysqldump -u root -p db03 users > d:\\bak1.sql
# 恢复备份的数据库
/*
方式1：
# 进入mysql命令行
dos> mysql -u root -p
# 恢复备份
mysql> source d:\\bak.sql
方式2：
直接复制备份的数据库文件(其实就是sql语句)中的内容，在编辑器下全部运行即可
*/
