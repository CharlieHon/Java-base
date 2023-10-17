package com.hspedu.smallchange;

import com.sun.corba.se.impl.ior.ObjectAdapterIdNumber;
import com.sun.xml.internal.bind.v2.TODO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    // 1. 先完成显示菜单，并可以选择菜单，给出对应提示
    // 2. 完成零钱通细节
    // 3. 收益入账
    // 4. 消费
    // 5. 退出
    public static void main(String[] args) {
        // 1. 定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        // 2. 完成零钱通细节
        // 思路：(1) 可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3) 使用String拼接
        String details = "----------零钱通明细----------";

        // 3. 收益入账 完成功能驱动增加新的变化和代码
        // 思路：定义新的变量
        double money = 0.;  //
        double balance = 0; // 余额
        Date date = null;   // 日期 java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");    // 用于日期格式化

        // 4. 消费
        String note = "";    // 定义变量，记录消费说明

        // 原项目改进
        // 用户输入4退出时，给出提示
        String confirm = "";

        do {
            // 显示菜单
            System.out.println("\n==========零钱通菜单==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退     出");

            System.out.print("请选择(1~4)：");
            key = scanner.next();

            // 使用 switch 分支控制
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    if (money <= 0) {   // 金额校验
                        System.out.println("收益入账金额 需要 大于 0");
                        break;
                    }
                    balance += money;
                    date = new Date();  // 获取当前信息
                    // 修改收益信息
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "3":
                    System.out.print("消费说明：");
                    note = scanner.next();
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    if (money < 0) {
                        System.out.println("消费金额 需要 大于等于 0");
                        break;
                    } else if (money > balance) {
                        System.out.println("消费金额不能超出余额，您的消费应该在0.0 ~ " + balance);
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    // 拼接消费信息到 details
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "4":
                    // 用户输入4退出时，给出提示
                    while (true) {
                        System.out.print("你确定要退出吗？y/n：");
                        confirm = scanner.next();
                        if ("y".equals(confirm)) {
                            loop = false;
                            System.out.println("4 退     出");
                            break;
                        } else if ("n".equals(confirm)) {
                            break;
                        }   // else 不是 y/n，一直循环下去
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }

        } while (loop);

        System.out.println("----- 退出了零钱通系统 -----");

    }
}
