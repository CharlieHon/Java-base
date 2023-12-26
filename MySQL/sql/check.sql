# check
-- mysql5.7目前还不支持check，只做语法校验，但不会生效
CREATE TABLE t6 (
	id INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	gender CHAR(1) CHECK (gender IN ('男', '女')),
	sal DOUBLE CHECK (sal > 1000 AND sal < 2000)
);
INSERT INTO t6 VALUES (1, 'charlie', '男', 8000); -- sal不符合check但仍会添加成功
