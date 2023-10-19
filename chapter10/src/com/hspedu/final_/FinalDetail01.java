package com.hspedu.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        CC cc = new CC();   // final类不能被继承，但是可以实例化
        new EE().test();
        System.out.println("OK~");
    }
}

class AA {
    /*
    1. 在定义时赋初值
    2. 在构造器中
    3. 在代码块中
     */
    public final double N1 = 1.2;   // 定义时赋值
    public final double N2;
    public final double N3;

    public AA() {
        N2 = 1.3;   // 在构造器中赋值
    }

    {
        N3 = 3.1;   // 在代码块中赋值
    }
}

class BB {
    /*
    如果 final 修饰的属性是 static 的，则初始化的位置只能是
    1. 定义时  2. 在静态代码块，不能在构造器中赋值
     */
    public final static double N1 = 1.2;
    public final static double N2;
    public BB() {
        // 因为构造器是在创建对象的时候调用的
        // 而静态属性初始化需要在类加载的时候进行，所以final修饰的static属性不能在构造器中初始化
//        N2 = 6.2;   // 错误：在构造器中初始化，可能造成 final 修饰的静态属性未被初始化
    }

    static {
        N2 = 3.2;
    };
}

// final类不能继承，但是可以实例化
final class CC {}

// 如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
// 仍然遵守继承机制
class DD {
    public final void sayHi() {
        System.out.println("DD: sayHi()...");
    }
}

class EE extends DD {
    public void test() {
        System.out.println("在EE类中调用DD的final方法");
        // sayHi() 是父类的 final 方法，不能重写，但是被继承了
        sayHi();
    }
}