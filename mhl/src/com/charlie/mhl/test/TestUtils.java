package com.charlie.mhl.test;

import org.junit.Test;

import java.util.UUID;

public class TestUtils {
    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            String str1 = UUID.randomUUID().toString();
            System.out.println(str1);
        }
    }
}
