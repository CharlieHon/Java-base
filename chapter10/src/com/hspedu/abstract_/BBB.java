package com.hspedu.abstract_;

public class BBB extends Template {
    @Override
    public void job() {
        int sum = 1;
        for (int i = 1; i <= 1000000; i++) {
            sum *= i;
        }
    }
}
