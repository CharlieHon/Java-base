# 商品收获系统表设计案例
CREATE DATABASE IF NOT EXISTS shop_db;
USE shop_db;
CREATE TABLE goods (
	goods_id INT PRIMARY KEY,
	goods_name VARCHAR(64) NOT NULL DEFAULT '',
	unitprice DECIMAL(10, 2) NOT NULL CHECK (unitprice >= 1.0 AND unitprice <= 9999.99) ,
	catagory INT NOT NULL DEFAULT 0,
	provider VARCHAR(16) NOT NULL DEFAULT ''
);
CREATE TABLE customer (
	customer_id INT PRIMARY KEY,
	`name` VARCHAR(16) NOT NULL DEFAULT '',
	address VARCHAR(64) NOT NULL DEFAULT '',
	email VARCHAR(16) UNIQUE NOT NULL,
	gender ENUM('男', '女') NOT NULL,
	card_Id CHAR(18) UNIQUE
);
CREATE TABLE purchase (
	order_id INT UNSIGNED PRIMARY KEY,
	customer_id INT NOT NULL DEFAULT 0,
	goods_id INT NOT NULL DEFAULT 0,
	nums INT NOT NULL DEFAULT 0,
	-- 指定外键关系
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY (goods_id) REFERENCES goods(goods_id)
);

-- drop table goods;
-- DROP TABLE customer;
-- DROP TABLE purchase;
SHOW TABLES;
