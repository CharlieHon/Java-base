package com.hspedu.homework.homework08;

public class HomeWork08 {
    public static void main(String[] args) {
//        CheckingAccount account = new CheckingAccount(1000);
//        account.deposit(10);
//        System.out.println(account.getBalance());

        // 测试 SavingAccount
        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance()); // 1300
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance()); // 1399

        // 月初，定时器自动调用以下 earnMonthlyInterest
        savingAccount.earnMonthlyInterest();    // 统计利息
        System.out.println(savingAccount.getBalance()); // 1412.99
        savingAccount.withdraw(100);    // 免手续费
        System.out.println(savingAccount.getBalance()); // 1312.99

    }
}
