package com.hspedu.extend_;

import java.awt.*;

public class Extend01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.age = 18;
        pupil.testing();
        pupil.setScore(78);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 22;
        graduate.testing();
        graduate.setScore(99);
        graduate.showInfo();
    }
}
