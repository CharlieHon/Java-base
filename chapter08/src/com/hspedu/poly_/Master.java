package com.hspedu.poly_;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    // 完成主任给小狗喂食
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人 " + name + " 给 " +
//                dog.getName() + " 喂 " + bone.getName());
//    }
//    // 主人给 小猫 喂 三文鱼
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人 " + name + " 给 " +
//                cat.getName() + " 喂 " + fish.getName());
//    }
    // 多态(Polymorphic)
    public void feed(Animal a, Food f) {
        // a的编译类型是 Animal，可以指向(接收)Animal子类的对象
        System.out.println("主人 " + name + " 给 " +
                a.getName() + " 喂 " + f.getName());
    }
}
