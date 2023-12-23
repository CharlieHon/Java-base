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
