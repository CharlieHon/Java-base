package com.exercise_;


public class Homework02 {
    public static void main(String[] args) {

        String name = "tom";
        String pwd = "123445";
        String email = "john@qq.com";
        try {
            userMessage(name, pwd, email);
            System.out.println("注册成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userMessage(String name, String pwd, String email) {

        if (name == null || pwd == null || email == null) {
            throw new RuntimeException("姓名、密码、邮件不能为空");
        }
        // 1. 判断姓名长度是否为2或3或4
        if (!(name.length() ==2 || name.length() == 3 || name.length() == 4)) {
            throw new RuntimeException("姓名长度是为2或3或4");
        }
        // 2. 密码长度为6，且全部为数字
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码长度为6，且全部为数字");
        }
        // 3. 邮箱中有@，且@在.之前
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && i < j)) {
            throw new RuntimeException("邮箱中有@，且@在.之前");
        }
    }

    public static boolean isDigital(String pwd) {
        char[] value = pwd.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (!(value[i] >= '0' && value[i] <= '9')) {
                return false;
            }
        }
        return true;
    }
}
