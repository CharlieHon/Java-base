package chapter09.houserent.utils;

public class TestUtility {
    public static void main(String[] args) {

        //这是一个测试类，使用完毕，就可以删除了
        //要求输入一个字符串，长度最大为3
//        String s = Utility.readString(3);
//        System.out.println("s=" + s);

        //要求输入一个字符串，长度最大为10, 如果用户直接回车，就给一个默认值
        //老师提示：就把该方法当做一个api使用即可
        System.out.println("请输入字符串:");
        String s2 = Utility.readString(10, "hspedu");
        System.out.println("s2=" + s2);

        //直接使用 类.方法() => 因为当一个方法是static时，就是一个静态方法
        // 静态方法可以直接通过 类名.方法名 来调用
//        A.hi(); // 错误，成员方法，不能这样调用
        A.cry();
    }
}

class A {
    public void hi() {

    }
    public static void cry() {

    }
}
