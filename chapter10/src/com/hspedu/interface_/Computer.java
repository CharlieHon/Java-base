package com.hspedu.interface_;

public class Computer {
    // 编写一个方法，计算机工作
    public void work(UsbInterface usbInterface) {
        // 通过接口，调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
