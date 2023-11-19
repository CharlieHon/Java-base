package com.hspedu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = Class.forName("com.hspedu.homework.PrivateTest");
        Class<PrivateTest> cls = PrivateTest.class;
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);   // 爆破
        System.out.println(name.get(o));    // hellokitty
        name.set(o, "hsp");
        Method getName = cls.getMethod("getName");
        System.out.println("调用getName：" + getName.invoke(o));   // 调用getName：hsp
    }
}

class PrivateTest {
    private String name = "hellokitty";
    public String getName() {
        return name;
    }
}