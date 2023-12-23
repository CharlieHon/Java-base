# 演示删除和查询数据库
# 查看当前数据库服务器中的所有数据库
SHOW DATABASES;
# 查看指定的数据库的定义信息
SHOW CREATE DATABASE hsp_db02;
# 在创建数据库，表时，为了规避关键字，可以使用反引号解决
CREATE DATABASE `create`;	# 创建名为 create 的数据库
# 删除前面创建创建的 hsp_db01 数据库
DROP DATABASE IF EXISTS hsp_db01;
