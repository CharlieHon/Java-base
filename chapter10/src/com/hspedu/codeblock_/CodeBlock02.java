package com.hspedu.codeblock_;

public class CodeBlock02 {
    public static void main(String[] args) {
        // 类被加载的情况举例
        // 1. 创建对象实例时(new)
//        BB bb = new BB();   // BB 的静态代码块~
//        BB bb = new BB();   // 类已经被加载，静态代码块不会被执行
        // 2. 创建子类对象实例时，父类也会被加载。而且父类先被加载，子类后被加载
//        AA aa = new AA();
        // 3. 使用类的静态成员时(静态方法，静态属性)
        Cat.sayHi();    // 因为要先加载类，在执行静态方法，所以会先执行静态代码块

        // 普通代码块，在创建对象实例时，会被隐式的调用
        // 创建一次，就会调用一次
        // 如果只是使用类的静态成员，普通代码块并不会执行
        System.out.println(DD.n1);  // 先加载类 -> 静态代码块被调用 -> 输出DD.n1；普通代码块不会被调用
    }
}

class DD {
    public static int n1 = 6;
    // 静态代码块
    static {
        System.out.println("DD 的静态代码块被执行...");
    };

    // 普通代码块
    // 在 new 对象时被调用，而且是每创建一个对象，就调用一次
    // 可以这样简单理解，普通代码块是构造器的补充
    {
        System.out.println("DD 的普通代码块被执行...");
    };
}

class Cat {
    public static int n1 = 1;
    public static void sayHi() {
        System.out.println("Cat.sayHi()...");
    }
    static {
        System.out.println("Cat 的静态代码块~");
    }
}

class BB {
    static {
        System.out.println("BB 的静态代码块~");
    };
}

class AA extends BB {

    // AA类的静态代码块
    static {
        System.out.println("AA 的静态代码块~");
    };
}