package com.charlie.mhl.domain;

/**
 * 这时一个javabean 和 employee 对应
 * CREATE TABLE employee (
 * 	id INT PRIMARY KEY AUTO_INCREMENT, # 自增
 * 	empId VARCHAR(32) NOT NULL DEFAULT '',	# 员工号
 * 	pwd CHAR(32) NOT NULL DEFAULT '',	# 密码 md5
 * 	`name` VARCHAR(32) NOT NULL DEFAULT '', # 姓名
 * 	job VARCHAR(64) NOT NULL DEFAULT ''	# 岗位
 * ) CHARSET=utf8;
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;

    public Employee() { // 无参构造器，底层 apache-dbutils 反射需要
    }

    public Employee(Integer id, String empId, String pwd, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
