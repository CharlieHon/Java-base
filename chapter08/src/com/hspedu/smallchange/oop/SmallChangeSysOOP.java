package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类完成 零钱通 的各个功能
 * 使用面向对象编程(OOP)
 * 将各个功能对应为一个方法
 */
public class SmallChangeSysOOP {
    private boolean loop = true;
    private Scanner scanner = new Scanner(System.in);
    private String key = "";
    private String details = "----------零钱通明细----------";
    private double money = 0.;  //
    private double balance = 0; // 余额
    private Date date = null;   // 日期 java.util.Date 类型，表示日期
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");    // 用于日期格式化

    // 1. 完成显示菜单
    public void showMenu() {
        do {
            System.out.println("\n==========零钱通菜单(OOP)==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退     出");

            System.out.print("请选择(1~4):");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }
        } while (loop);
    }

    // 2. 零钱通明细
    public void detail() {
        System.out.println(details);
    }

    // 3. 收益入账
    public void income() {
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        if (money <= 0) {   // 金额校验，不符合直接退出方法
            System.out.println("收益入账金额 需要 大于 0");
            return; // 退出方法，不再执行后面的代码
        }
        balance += money;
        date = new Date();  // 获取当前信息
        // 修改收益信息
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void pay() {
        System.out.print("消费说明：");
        // 定义变量，记录消费说明
        String note = scanner.next();
        System.out.print("消费金额：");
        money = scanner.nextDouble();
        if (money < 0) {
            System.out.println("消费金额 需要 大于等于 0");
            return;
        } else if (money > balance) {
            System.out.println("消费金额不能超出余额，您的消费应该在0.0 ~ " + balance);
            return;
        }
        balance -= money;
        date = new Date();
        // 拼接消费信息到 details
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void exit() {
        while (true) {
            System.out.print("你确定要退出吗？y/n：");
            String confirm = scanner.next();
            if ("y".equals(confirm)) {
                loop = false;
                System.out.println("4 退     出");
                break;
            } else if ("n".equals(confirm)) {
                break;
            }   // else 不是 y/n，一直循环下去
        }
    }

}
