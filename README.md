# Java基础

## DOS命令

- DOS介绍

Dos：`Disk Operating System`磁盘操作系统

```dos
# 命令行输入指令

# Dos系统：1.接受指令 2.解析指令 3.执行指令

# window文件系统相应操作
```

- 相对路径，绝对路径

> 相对路径：从当前目录开始定位，形成的一个路径
>
> `..\..\abc2\test200\hello.txt`
>
> 绝对路径：从顶级目录/根目录开始定位，形成的路径
>
> `d:\abc2\test200\hello.txt`

- 常用的dos命令

1. 查看当前目录是什么内容

> `dir`
>
> `dir d:\abc2\test200`

2. 切换到其他盘下：盘符号 cd

> 切换到c盘	`cd /D c:`

3. 切换到当前盘的其他目录下

> `cd d:\abc2\test200`
>
> `cd ..\..\abc2\test200`

4. 切换到上一级

> `cd ..`

5. 切换到当前目录的根目录

> `cd \`

6. 查看指定的目录下所有的子级目录 `tree`
7. 清屏 `cls`
8. 退出DOS `exit`
9. 其他指令

```dos
# md 创建目录
> md test

# rd 删除目录
> rd test

# 创建文件，并输入内容
> echo Hello > Hello.txt

# 创建空文件
> type nul > abc.txt

# 删除文件
> del abc.txt

# 拷贝
> copy Hello.txt e:\javacode\test\Hello

# 剪切
move Hello.txt d:\tmp
```

## Java

### 对象创建的流程分析

```java
class Person {
    String name;
    int age = 18;
    // 构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {   // 默认构造函数
        age = 18;
    }
}

Person p = new Person("Bruce", 12);
```

> 执行 `Person p = new Person("Bruce", 12);`
>
> 1. 在方法区加载 `Person`类，只会加载一次。
> 2. 在堆区分配空间(地址)，如 `0x1122`，存放 `age`和 `name`。
> 3. 完成对象初始化。
>    1. 先进行**默认初始化**，`age = 0; name -> null`；
>    2. 然后将 `age`**显式初始化**为90
>    3. 最后执行**构造器初始化**，在常量池存放 `String`的值 `Bruce`，地址为 `0x1133`，堆区 `name`存放该地址。将 `age`更改为20.
> 4. 将对象在堆中的地址 `0x1122`返回给引用 `p`，`p`在栈区，是对象的引用。

### this

```java
package chapter07;
public class This {
    public static void main(String[] args) {
        /** This
         * 1. this关键字可以用来访问本类的属性、方法、构造器
         * 2. this用于区分当前类的属性和局部变量
         * 3. 访问成员方法的语法：this.方法名(参数列表)
         * 4. 访问构造器语法：this(参数列表)；只能在构造器中使用
         *      即，只能在构造器中访问另外一个构造器
         *      并且必须放在第一条语句
         * 5. this不能再类定义的外部使用，只能在类定义的方法中使用
         */
        T t1 = new T();
        t1.f2();
    }
}

class T {

    String name;
    int age;

    public T() {
        // 注意：如果有this(参数列表);
        // 则该语句必须放在第一条语句
        this("jack", 100);
        System.out.println("T() 构造器");
    }
    public T(String name, int age) {
        System.out.println("T(String name, int age) 构造器");
    }

    public void f1() {
        System.out.println("f1() 方法...");
    }
  
    public void f2() {
        System.out.println("f2() 方法...");
        // 调用本类的f1
        f1();
        this.f1();
    }

    public void f3() {
        System.out.println("name = " + name + " age = " + age);
        System.out.println("this.name = " + this.name + " this.age = " + this.age);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}
```

## END
