package com.hspedu.extend_.improve_;

import com.hspedu.extend_.Graduate;
import com.hspedu.extend_.Pupil;

public class Extends {
    public static void main(String[] args) {
        com.hspedu.extend_.Pupil pupil = new Pupil();
        pupil.name = "银角大王";
        pupil.age = 16;
        pupil.testing();
        pupil.setScore(78);
        pupil.showInfo();

        com.hspedu.extend_.Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 23;
        graduate.testing();
        graduate.setScore(99);
        graduate.showInfo();
    }
}
