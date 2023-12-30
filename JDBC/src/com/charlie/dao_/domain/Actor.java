package com.charlie.dao_.domain;

import java.util.Date;

/**
 * Actor对象和actor表的记录对应
 */
public class Actor {    // JavaBean, POJOm Domain对象
    private Integer id;
    private String name;
    private String gender;
    private Date borndate;
    private String phone;

    public Actor() {
        // 一定要给一个无参构造器(反射需要)
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Actor(Integer id, String name, String gender, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.borndate = borndate;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
