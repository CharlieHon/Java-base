# 备份和恢复数据库
# 备份数据库，需要在 DOS 下执行 mysqldump指令 (Mysql\bin\mysqldump.exe)
# 备份的文件，其实就是对应的sql语句
# dos> mysqldump -u root -p -B db03 hsp_db02 > d:\\bak.sql

# 恢复数据库(注意：进入到Mysql命令行再执行)
# mysql> source d:\\bak.sql
# 恢复方法2：直接将 bak.sql 的内容放到查询编辑器中，全部执行即可


# 备份和恢复数据库的表
mysqldump -u -p 数据库 表1 表2 表n > d:\\bak1.sql
# 恢复：
/*
1. 进入到 mysql命令行
	dos> mysql -u root -p
2. 选择数据库
	mysql> use db03
3. 恢复数据库中备份的表
	mysql> source d:\\bak1.sql
*/
