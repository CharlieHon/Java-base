# MySQL

命令行窗口连接MySQL数据库
```
# 启动mysql数据库的常用方法[Dos命令]
> net start mysql   # 启动mysql服务
> net stop mysql    # 关闭服务

# 登录mysql服务，登录前保证服务启动
> mysql -h 主机名 -P 端口号 -u 用户名 -p密码
# 示例
> mysql -h 127.0.0.1 -P 3306 -u root -p9527
# 注意：-p和密码之间不空格，或者输入到-p直接回车，再进行密码验证
```

- ![操作示意图](img_2.png)
- 使用 `netstat -abn` 查看服务及监听端口
- ![netstat -abn](img.png)
- ![mysql](img_1.png)

## 数据库三层结构

1. 所谓安装Mysql数据库，就是在主机上安装一个数据库管理系统(database manage system, DBMS)，这个管理程序可以管理多个数据库
2. 一个数据库中可以创建多个表，以保存数据(信息)
3. 数据库管理系统(DBMS)、数据库和表的关系如下图所示：
   - ![Mysql三层结构](img_3.png)
   - Mysql数据库-普通表的本质仍然是**文件**
4. 数据在数据库中的存储方式
   - ![img_4.png](img_4.png)
   - 表的一行称之为一条记录
   - 在java程序中，一行记录往往使用对象表示
5. SQL语句分类
   - DDL：数据定义语句 [create 表, 库...]
   - DML：数据操作语句 [增加 insert, 修改 update, 删除 delete]
   - DQL：数据查询语句 [select]
   - DCL：数据控制语句 [管理数据库：比如用户权限 grant revoke]

## 数据库

### 创建数据库

- ![创建数据库](img_5.png)
  1. `CHARACTER SET`：指定数据库采样的字符集，如果不指定字符集，默认 `utf8`
  2. `COLLATE`：指定数据库字符集的校对规则
     1. `utf8_bin`：区分大小写
     2. `utf8_general_ci`：**不区分大小写，默认选项**

```mysql
# 创建数据库，默认不区分大小写
CREATE DATABASE IF NOT EXISTS hsp_db01;
# 删除数据库
DROP DATABASE hsp_db01;
# 创建数据库 hsp_db02 区分大小写
CREATE DATABASE hsp_db02 CHARACTER SET utf8 COLLATE utf8_bin;
# 查询语句，select 查询 * 表示所有字段
# from 从哪个表 where 从哪个字段 name = 'tom' 查询名字是tom
SELECT * FROM t1 WHERE NAME = 'tom';
```

- ![表数据](img_6.png)
- 以上查询语句，对于 `hsp_db01` 和 `hsp_db02` 的执行结果分别如下：
  - ![db01](img_7.png)
  - ![db02](img_8.png)

### 查看、删除数据库

- ![img_9.png](img_9.png)

```mysql
# 演示删除和查询数据库
# 查看当前数据库服务器中的所有数据库
SHOW DATABASES;
# 查看指定的数据库的定义信息
SHOW CREATE DATABASE hsp_db02;
# 在创建数据库，表时，为了规避关键字，可以使用反引号解决
CREATE DATABASE `create`;	# 创建名为 create 的数据库
# 删除前面创建创建的 hsp_db01 数据库
DROP DATABASE IF EXISTS hsp_db01;
```

### 备份和恢复数据库

- ![备份和恢复数据库](img_10.png)

```mysql
# 备份和恢复数据库
# 备份数据库，需要在 DOS 下执行 mysqldump指令(即：Mysql\bin\mysqldump.exe)
# 备份的文件，其实就是对应的sql语句
# dos> mysqldump -u root -p -B db03 hsp_db02 > d:\\bak.sql

# 恢复数据库(注意：进入到Mysql命令行再执行)
# mysql> source d:\\bak.sql
# 恢复方法2：直接将 bak.sql 的内容放到查询编辑器中，全部执行即可


# 备份和恢复数据库的表
# dos> mysqldump -u -p 数据库 表1 表2 表n > d:\\bak1.sql
/* 恢复备份的数据库中的表
1. 进入到 mysql命令行
	dos> mysql -u root -p
2. 选择数据库
	mysql> use db03
3. 恢复数据库中备份的表
	mysql> source d:\\bak1.sql
*/
```

<hr/>

```mysql
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
```

## 表

### 创建表

- ![创建表](img_11.png)

```mysql
# 创建表
CREATE TABLE `user` (
	id INT,
	`name` VARCHAR(255),
	`password` VARCHAR(32),
	`birthday` DATE)
	CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;
```

### Mysql常用数据类型(列类型)

- ![Mysql数据类型](img_12.png)
1. 数值类型
    - 整型
      - `tinyint[1个字节]`
      - `smallint[2个字节]`
      - `mediumint[3个字节]`
      - `int[4个字节]`：※
      - `bigint[8个字节]`
      - `BIT(M)`：位类型，M指定位数，默认值1，范围1~64
    - 小数类型
      - `float[单精度 4字节]`
      - `double[双精度 8字节]`：※
      - `decimal[M,D]`：根据M和D确定精度，M指定长度，D表示小数点的位数 ※
2. 文本类型(字符串类型)
   - `char`：0~255 ※
   - `varchar`：0~65535(2^16-1) ※
   - `text`：0~2^16-1 ※
   - `longtext`：0~2^32-1
3. 二进制数据类型
   - `blob`：0~2^16-1
   - `longblob`：0~2^32-1
4. 日期类型
   - `date`：日期：年/月/日
   - `time`：事件：时/分/秒
   - `datetime`：年月日时分秒 [YYYY-MM-DD-HH:mm:ss] ※
   - `timestamp`：时间戳
   - `year`：年

- 数值型(整数)的基本使用
1. 说明：在能满足需求的情况下，尽量选择占用空间小的类型
2. ![整型](img_13.png)

```mysql
# 演示整型使用
# 说明：表的字符集、校验规则、存储引擎使用默认
# 1. 如果没有指定 unsigned ，则默认数值类型都为有符号类型
# 2. 以 tinyint 为例，有符号范围 -128~127 无符号 0~255
CREATE TABLE t2 (
	id TINYINT);
CREATE TABLE t3 (
	id TINYINT UNSIGNED);	# 无符号类型

INSERT INTO t2 VALUES(-128);	# 添加语句
SELECT * FROM t2;

INSERT INTO t3 VALUES(255);
SELECT * FROM t3;
```

- 数值型(bit)
- `bit`字段显示时，按照位的方式显示
- 查询的时候仍然可以使用添加的数值进行查询，如添加255，在数据库中保存为 `b'11111111'`，
    在查询时，仍然可以按照 255 查询
- 如果一个值只有0和1，可以考虑使用 `bit(1)` 节约空间
- 位类型，`bit(M)` M指定位数，默认值1，范围1~64

```mysql
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
```

- 数值型(小数类型)
- ![小数类型](img_14.png)
- ![数据保存结果](img_15.png)

```mysql
# 演示decimal类型、float、double使用

# 创建表
CREATE TABLE t5 (
	num1 FLOAT,
	num2 DOUBLE,
	num3 DECIMAL(30, 20));	# 30位长，20个小数位
# 添加数据
INSERT INTO t5 VALUES (88.12345678912345, 88.12345678912345, 88.12345678912345);
SELECT * FROM t5;
```

- 字符串
- ![字符串](img_16.png)
- ![img_17.png](img_17.png)
- ![img_18.png](img_18.png)

```mysql
# 演示字符串类型使用 char varchar
# 注释的快捷键：shift+ctrl+c 取消注释：shift+ctrl+r
/*
CHAR(size)
- 固定长度字符串，最大255   字符
VARCHAR(size)
- 可变长度字符串，最大65535 字节    [utf8编码最大21844个字符，1~3个字节用于记录大小]
-- 如果表的编码是 utf8 varchar(size) size = (65535 - 3) / 3 = 21844(字符)
-- 如果表的编码是 gbk varchar(size) size = (65535 - 3) / 2 = 32766(字符)
*/


CREATE TABLE t6 (
	`name` CHAR(255));
CREATE TABLE t7 (
	`name` VARCHAR(21844));
CREATE TABLE t8 (
	`name` VARCHAR(32766)) CHARSET gbk;
-- drop table t8;


# 字符串使用细节
/*
* 细节1
* 1. char(4) 这个4表示字符数(最大255)，不是字节数，不管是中文还是字母都是放4个，按字符计算
* 2. varchar(4) 这个4也是表示字符串，不管是字母还是中文都是以定义好的表的编码方式来存放数据
* 细节2
* 1. char(4)是定长(固定的大小)，即使插入 'aa' 也会占用分配的4个字符的空间
* 2. varchar(4)是变长(变化的大小)，即如果插入了 'aa'，实际占用空间大小并非4个字符，而是按照实际
*	占用空间分配。varchar本身还需要占用1~3个字节来记录存放内容长度。L(实际数据大小) + (1~3)字节
* 细节3
* 什么使用使用 char 什么时候使用varchar
* 1. 如果数据是定长，推荐使用char，比如md5的密码、邮编、手机号、身份证号码等
* 2. 如果一个字段的长度是不确定的，就是用varchar，比如留言、文章
* 3. 查询速度：char > varchar
*/
CREATE TABLE t6 (
	`name` CHAR(4));	# 4表示字符个数，不区分是字母还是汉字。可以少于，不可多于
INSERT INTO t6 VALUES('史塔克');
SELECT * FROM t6;

CREATE TABLE t7 (
	`name` VARCHAR(4));
INSERT INTO t7 VALUES('拜拉席恩');
SELECT * FROM t7;

# 如果varchar不够用，可以使用mediumtext或者longtext
# 也可以简单点，直接使用text
CREATE TABLE t8 (content TEXT, context2 MEDIUMTEXT, context3 LONGTEXT);
INSERT INTO t8 VALUES('史塔克', '犀利01', '拜拉席恩');
SELECT * FROM t8;
```

- 日期类型的基本使用
- ![img_19.png](img_19.png)
- ![img_20.png](img_20.png)

```mysql
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
```

### 修改表

- ![img_21.png](img_21.png)

<hr/>

```mysql
# 创建一个员工表 emp
SELECT DATABASE();
# 删除数据库 db03
DROP DATABASE IF EXISTS db03;
# 查看当前有哪些数据库
SHOW DATABASES;
# 创建数据库 db01
CREATE DATABASE IF NOT EXISTS db01;
# 创建员工表 emp
CREATE TABLE emp (
	id INT,
	NAME VARCHAR(16),
	gender CHAR(1),
	birthday DATE,
	entry_date DATE,
	job VARCHAR(32),
	salary DOUBLE UNSIGNED,
	`resume` TEXT
	) CHARSET utf8 COLLATE utf8_general_ci ENGINE INNODB;
# 查看当前数据库有哪些表
SHOW TABLES;
# 查看表结构，可以查看表的所有列
DESC emp;


# 修改表
# 在 emp表 上增加一个 image列 varchar类型 要求在(resume列)后面
ALTER TABLE emp ADD image VARCHAR(16) NOT NULL DEFAULT '' 
			AFTER `resume`;	-- 在 resume字段 后面添加 image字段
# 修改 job列，使其长度为60
ALTER TABLE emp MODIFY job VARCHAR(60);
# 删除 gender列
ALTER TABLE emp DROP gender;
# 修改表名改为 employee
RENAME TABLE emp TO employee;
SHOW TABLES;	-- 查看发现已修改表名
DESC employee;
# 修改表的字符集为 utf8
ALTER TABLE employee CHARSET utf8;
# 将列名 name 修改为 user_name
ALTER TABLE employee CHANGE `name` use_name VARCHAR(32) NOT NULL DEFAULT '';
```

### CRUD

数据库C[create]R[read]U[update]D[delete]
1. Insert语句-添加数据
2. Update语句-更新数据
3. Delete语句-删除数据
4. Select语句-查找数据



