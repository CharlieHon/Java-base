package com.hspedu.abstract_;

public class AAA extends Template{
    @Override
    public void job() { // 实现 Template 的抽象方法 job
        int sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
    }
}
