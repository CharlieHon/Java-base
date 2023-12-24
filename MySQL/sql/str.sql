# 演示 字符串相关函数
-- charset(str) 返回字符串字符集
SELECT CHARSET(ename) FROM emp;
-- concat() 连接字符串
SELECT CONCAT(ename, ' job is ', job) FROM emp;
-- instr (string, substring) 返回 substring 在 string 中出现的位置，没有则返回0
# DUAL：亚元表，系统表用于测试
SELECT INSTR ('hanshunping', 'ping') FROM DUAL;	# 8

-- ucase 转成大写 lcase 转成小写
SELECT UCASE(ename), LCASE(ename) FROM emp;

-- left(string, length) 从string中的左边起取出length个字符 right从右边取
SELECT LEFT(ename, 2) FROM emp;

-- length(str) string长度，按照字节
SELECT LENGTH(ename) FROM emp;	-- length('李自成') 3*3=9

-- replace(str, search_str, replace_str) 在str中用search_str替换search_str
-- 			查找job，如果是 MANAGER 就替换为 经理
SELECT ename, REPLACE(job, 'MANAGER', '经理') FROM emp;

-- strcmp(str1, str2) 逐字符比较两字符串大小
SELECT STRCMP('asp', 'hsp') FROM DUAL;	-- -1

-- substring(str, position, [, length]) 从str的position位置开始[从1开始计算]，取length个字符
SELECT SUBSTRING(ename, 1, 2) FROM emp;

-- ltrim rtrim trim 取出前端或后端或左右两端的空格
SELECT LTRIM(' 李自成') FROM DUAL;
SELECT RTRIM('李自成  ') FROM DUAL;
SELECT TRIM('  李自成 ') FROM DUAL;

# 练习：以首字母小写的方式显示所有员工emp的姓名：两种方式
SELECT CONCAT(LCASE(SUBSTRING(ename, 1, 1)), SUBSTRING(ename, 2)) AS `name` FROM emp;
SELECT CONCAT(LCASE(LEFT(ename, 1)), SUBSTRING(ename, 2)) AS name2 FROM emp;
