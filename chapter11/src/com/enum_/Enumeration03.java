package com.enum_;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
    }
}
// 演示使用关键字enum实现枚举类
enum Season2 {
//     定义了四个对象
//    public static final Season2 SPRING = new Season2("春天", "温暖");
//    public static final Season2 SUMMER = new Season2("夏天", "炎热");
//    public static final Season2 AUTUMN = new Season2("秋天", "萧瑟");
//    public static final Season2 WINTER = new Season2("冬天", "寒冷");

//     如果使用了 enum 来实现枚举类
//     1. 使用关键字 enum 替代 class
//     2. public static final Season2 SPRING = new Season2("春天", "温暖");
//      ->  SPRING("春天", "温暖");
//          常量名(实参列表);
//     3. 如果有多个常量(对象)，使用 , 逗号间隔即可
//     4. 如果使用 enum 实现枚举，要求将定义的常量对象，写在前面
    // 5. 如果使用的无参构造器，创建常量对象，则可以省略 ()
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "萧瑟"), WINTER("冬天", "寒冷"),
    What;   // What 是 What() 的简写，调用无参构造器
    private String name;
    private String desc;

    private Season2() { // 无参构造器
    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}