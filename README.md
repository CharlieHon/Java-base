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

### 包

包的三大作用：

1. 区分相同名字的类
2. 当类很多时，可以很好的管理类
3. 控制访问范围

包基本语法：`package com.hspedu`

1. `package`是关键字，表示打包
2. `com.hspedu`表示包名

包的本质：**实际上就是创建不同的文件夹/目录来保存类文件**

### 访问修饰符

- 4种访问修饰符的访问范围

| 访问级别 | 访问控制修饰符 | 同类 | 同包 | 子类 | 不同包 |
| -------- | -------------- | ---- | ---- | ---- | ------ |
| 公开     | `public`     | √   | √   | √   | √     |
| 受保护   | `protected`  | √   | √   | √   | ×     |
| 默认     | 没有修饰符     | √   | √   | ×   | ×     |
| 私有     | `private`    | √   | ×   | ×   | ×     |

- 使用注意事项

1. 修饰符可以用来修饰类种的属性，成员方法以及类
2. 只有默认的和 `public`才能修饰类！并且遵循上述访问权限的特点
3. **成员方法**的访问规则和**属性**完全一样

### 面向对象编程-封装

**封装**(`encapsulation`)就是把抽象出的数据[属性]和对数据的操作[方法]封装在一起，数据被保护在内部，程序的其他部分只有通过被授权的操作[方法]，才能对数据进行操作。

- 封装的理解和好处

1. 隐藏实现细节：方法(连接数据库) <--- 调用(传入参数)
2. 可以堆数据进行验证，保证安全合理

- 封装的实现步骤

1. 将属性进行私有化 `private`【不能直接修改属性】
2. 提供一个公共的(public)set方法，用于堆属性判断并赋值
3. 提供一个公共的(public)get方法，用于获取属性的值

### 面向对象编程-继承

> 继承可以解决代码复用，让编程更加接近人类思维。当多个类存在相同属性(变量)和方法时，可以从这些类种抽象出父类，在父类种定义这些相同的属性和方法，所有的子类不需要重新定义这些属性和方法，只需要通过 `extends`来声明继承父类即可。

- 继承的基本语法 `class 子类 extends 父类{}`

1. 子类就会自动拥有父类定义的属性和方法
2. 父类又叫超类、基类。子类又叫派生类

- 继承的深入讨论/细节

1. 子类继承了所有属性和方法，但是私有属性和方法不能在子类直接访问，要通过**父类提供公共的方法来访问**。
2. 子类必须调用父类的构造器，完成父类的初始化
3. 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会调用父类的无参构造器。如果父类没有提供无参构造器，则必须在子类的构造器中用 `super` 去显式指定使用父类的哪个构造器完成对象父类的初始化工作，否则，编译不会通过。
4. 如果希望指定去调用父类的某个构造器，则显式地指定它
5. `super`使用的时候，必须放在构造器的第一行，并且 `super`只能在构造器中使用
6. `super()`和 `this()`都只能放在构造器第一行，因此这两个方法不能共存在一个构造器中。
7. java所有类都是 `Object`类的子类，即 `Object`使所有类的基类。光标指定某个类，使用快捷键 `ctrl+H`可以查看该类的继承关系。
8. 父类构造器的调用不限于直接父类！将一直往上追溯知道 `Object`类(顶级父类)
9. 子类最多只能继承一个父类(指直接继承)，即java中是**单继承机制**。
10. 不能滥用继承，子类和父类之间必须满足 `is-a` 的逻辑关系。

- 继承的本质分析(重要)

```java
package com.hspedu.extend_;

public class ExtendTheory {
    public static void main(String[] args) {
        Son son = new Son();    // 内存的布局
        // ?-> 按照查找关系来返回信息
        // (1) 首先看子类是否有这个属性
        // (2) 如果子类有这个属性，并且可以访问，则返回信息
        // (3) 如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息...)
        // (4) 如果父类没有就按照(3)的规则，继续找上级父类，直到Object
        // 当查找到属性存在某个父类中时，如果没有访问权限就会报错，而不是继续向上级父类继续查找！
        System.out.println(son.name);   // 大头儿子；Son类中name是默认访问权限，在同一个包下可以访问
        System.out.println(son.age);    // 39
        System.out.println(son.hobby);  // 旅游
    }
}

class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}
class Father extends GrandPa {
    String name = "大头爸爸";
    int age = 39;
}
class Son extends Father {
    String name = "大头儿子";
}
```

执行 `Son son = new Son();`内存中的布局

1. 在方法去加载类。首先加载 `Object`，然后依次加载 `GranPa`，`Father`，`Son`
2. 在堆区开辟内存。首先为 `GrandPa`的属性开辟空间，然后依次为 `Father`，`Son`开辟内存空间。
3. 最后将对象地址 `0x11`返回给引用变量。对象中包含所有继承的属性。

![1697113951125](image/README/1697113951125.png)

### super关键字

- 基本介绍

`super`代表父类的引用，用于访问父类的属性、方法、构造器

- 基本语法

1. 访问父类的属性，但不能访问父类的 `private`属性。`super.属性`
2. 访问父类的方法，不能访问父类的 `private`方法。`super.方法名(参数列表)`
3. 访问父类的构造器：`super(参数列表)`；只能放在构造器的第一句，只能出现一句。

- super给编程带来的遍历/细节

1. 调用父类的构造器的好处(分工明确，父类属性由父类初始化，子类的属性由子类初始化)
2. 当子类中有和父类的成员(属性和方法)重名时，为了访问父类的成员，必须通过 `super`。如果没有重名，使用 `super`、`this` 和直接访问结果是一样的。`2023-10-12:P300`


1

## END
