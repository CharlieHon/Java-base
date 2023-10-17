package com.hspedu.homework.homework08;

public class SavingAccount extends BankAccount {
    // 新增属性
    private double rate = 0.01;    // 利率
    private int count = 3;

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        // 判断是否还可以免手续费
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount- 1);
        }
        --count;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        --count;
    }

    public void earnMonthlyInterest() { // 每个月初，统计上月利息，同时将count=3
        count = 3;
        super.deposit(getBalance() * rate);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
