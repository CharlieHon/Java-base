package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Dog tom = new Dog("Tom");
        Pig john = new Pig("John");
        Bone bone = new Bone("大骨拉面");
        Master bruce = new Master("Bruce");
        bruce.feed(john, bone);

        Cat jerry = new Cat("Jerry");
        Fish fish = new Fish("三文鱼");
        bruce.feed(jerry, fish);
//        System.out.println("cat.name=" + jerry.getName());    // Jerry
//        System.out.println("(cat.name)cat.name=" + jerry.name); // null
    }
}
