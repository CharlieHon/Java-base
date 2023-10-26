package com.enum_;

public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSIC.playing();
    }
}

// 1. 使用enum关键字后，就不能再继承其他类
//class A {
//
//}
//enum Season4 extends A {
//
//}
// 2. enum实现的枚举类，仍然是一个类，所以还是可以实现接口的
interface IPlaying {
    void playing();
}

enum Music implements IPlaying {
    CLASSIC, ROCK;
    @Override
    public void playing() {
        System.out.println("播放音乐....");
    }
}
