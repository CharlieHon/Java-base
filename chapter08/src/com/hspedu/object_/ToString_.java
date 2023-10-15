package com.hspedu.object_;

public class ToString_ {
    public static void main(String[] args) {
        /*  Object中的toString()方法
        // 1. getClass().getName()：类的全类名(包名+类名)
        // 2. Integer.toHexString(hashCode())：将对象的 hashCode 值转成16进制字符串
            public String toString() {
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            }
         */

        Monster monster = new Monster("小旋风", "巡山", 200);
//        System.out.println(monster.toString()); // 重写前：com.hspedu.object_.Monster@1b6d3586
        System.out.println(monster.toString()); // 重写后：Monster{name='小旋风', job='巡山', salary=200.0}
        System.out.println(monster);    // 当输出一个对象时，toString方法会被默认调用；输出同上
    }
}

class Monster {
    private String name;
    private String job;
    private double salary;

    public Monster(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    // 重写toString方法，输出对象的属性
    @Override
    public String toString() {  // 重写后，一般是把属性输出
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}