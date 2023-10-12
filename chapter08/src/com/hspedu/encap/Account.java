package com.hspedu.encap;

public class Account {
    private String name;
    private double money;
    private String passWord;

    public Account() {
    }

    public Account(String name, double money, String passWord) {
        setName(name);
        setMoney(money);
        setPassWord(passWord);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if (len == 2 || len == 3 || len == 4) {
            this.name = name;
        } else {
            System.out.println("姓名长度必须在2~4范围内，默认姓名：无名");
            this.name = "无名";
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money > 20) {
            this.money = money;
        } else {
            System.out.println("余额必须大于20，默认余额：0");
            this.money = 0; // 可以不写
        }
    }

    public void setPassWord(String passWord) {
        if (passWord.length() == 6) {
            this.passWord = passWord;
        } else {
            System.out.println("密码长度必须是六位，默认密码：123456");
            this.passWord = "123456";
        }
    }

    public void showInfo(String passWord) {
        if (passWord.equals(this.passWord)) {
            System.out.println("账户信息-姓名：" + name + "，余额：" + money);
        } else {
            System.out.println("账号密码错误，无权访问！");
        }
    }
}
