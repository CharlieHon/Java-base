package com.enum_;

public class EnumMethod {
    public static void main(String[] args) {
        // 演示 Enum类的各种方法使用
        Season3 winter = Season3.WINTER;
        // 1. name()：输出枚举对象的名字
        System.out.println(winter.name());  // Winter
        // 2. ordinal()：输出的是该枚举对象的次序/编号，从0开始编号
        System.out.println(winter.ordinal());   // 3
        // 3. values()：从反编译可以看出 values() ，返回 Season3[]
        // 含有定义的所有枚举对象
        Season3[] values = Season3.values();
        for (Season3 season: values) {  // 增强for循环，依次从数组中取出数据，如果取出完毕，则退出循环
            System.out.println("name: " + season.name() + ", ordinal: " + season.ordinal());
        }
        // 4. valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名
        // 执行流程
        // 1）根据输入的字符串，到Season3的枚举对象去查找
        // 2）如果找到了，就返回，如果没有找到，就报错
        Season3 winter1 = Season3.valueOf("WINTER");
        System.out.println(winter1); // WINTER
        System.out.println(winter1 == winter);  // true
        // 5. compareTo：比较两个枚举对象，比较的就是编号
        // 1）就是把 Season3.WINTER 的编号和 Season3.AUTUMN 比较
        // 2）即 Season3.WINTER.ordinal() - Season3.AUTUMN.ordinal()
        System.out.println(Season3.WINTER.compareTo(Season3.AUTUMN));   // 1 = 3 - 2
    }
}

enum Season3 {
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN, WINTER("冬天", "寒冷");
    private String name;
    private String desc;
    private Season3() {}    // 无参构造器
    private Season3(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}