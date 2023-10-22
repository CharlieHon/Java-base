package com.hspedu.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        // 多态传递现象
        // 接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new Teacher();
        // 接口类型也可以指向，实现了其子接口的类的实例对象
        IH ih = new Teacher();  // 相当于 Teacher 类也实现了 IH 接口
    }
}

interface IH {
    void hi();
}
interface IG extends IH {}

class Teacher implements IG {
    @Override
    public void hi() {  // 接口多态传递现象
        System.out.println("必须实现hi()...");
    }
}
