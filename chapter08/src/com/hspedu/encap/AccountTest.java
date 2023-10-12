package com.hspedu.encap;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("李牧");
        account.setMoney(1000.);
        account.setPassWord("476455");

        System.out.println("请输入账户密码：");
        Scanner scanner = new Scanner(System.in);
        String pw = scanner.next();
        account.showInfo(pw);
    }
}
