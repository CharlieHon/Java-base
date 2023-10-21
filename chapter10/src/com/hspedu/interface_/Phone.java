package com.hspedu.interface_;

// Phone类 实现 UsbInterface
// 即， Phone类需要实现 UsbInterface结构 规定/声明的方法
public class Phone implements UsbInterface{ // 实现接口
    @Override
    public void start() {
        System.out.println("手机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("手机结束工作...");
    }
}
