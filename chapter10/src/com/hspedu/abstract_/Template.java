package com.hspedu.abstract_;

abstract public class Template { // 抽象类-模板设计模式
    abstract public void job();

    public void calculateTime() {   // 实现方法，调用了 job()
        // 得到开始时间
        long start = System.currentTimeMillis();
        job();  // 动态绑定
        // 得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }
}
