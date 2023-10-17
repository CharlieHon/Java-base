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

1. 在方法区加载类。首先加载 `Object`，然后依次加载 `GranPa`，`Father`，`Son`
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
3. `super`的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以直接使用 `super`去访问爷爷类的成员；如果多个基类(上级类)中多有同名的成员，使用 `super`访问遵循就近原则。`A->B->C`。当然也需要遵循访问权限规则。

- `super`和 `this`的比较

| 区别点       | this                                                   | super                                    |
| ------------ | ------------------------------------------------------ | ---------------------------------------- |
| 访问属性     | 访问本类中的属性，如果本类没有此属性则从父类中继续查找 | 从父类开始查找属性                       |
| 调用方法     | 访问本类中的方法，如果本类没有此属性则从父类中继续查找 | 直接访问父类中的方法                     |
| 调用构造函数 | 调用本类构造器，必须放在构造器的首行                   | 调用父类构造器，必须放在子类构造器的首行 |
| 特殊         | 表示当前对象                                           | 子类中访问父类对象                       |

### 方法重写/覆盖 `override`

- 方法重写就是子类中有一个方法，和父类的某个方法的**名称、返回类型、参数都一样**，那么就说子类的这个方法重写/覆盖了父类的那个方法。

方法重写/覆盖，需要满足下面的条件

1. 子类方法的**形参列表，方法名称**，要和父类的参数，方法名称**完全一样**。
2. **子类方法的返回类型和父类方法的返回类型一样，或者是父类返回类型的子类**，必须父类返回类型是 `Object`，子类方法返回类型是 `String`。
3. 子类方法不能缩小父类方法的访问权限。

- 方法重写和重载

| 名称           | 发生范围 | 方法名   | 形参列表                         | 返回类型                                                         | 修饰符                                   |
| -------------- | -------- | -------- | -------------------------------- | ---------------------------------------------------------------- | ---------------------------------------- |
| 重载(overload) | 本类     | 必须一样 | 类型，个数或者顺序至少有一个不同 | 无要求                                                           | 无要求                                   |
| 重写(override) | 父子类   | 必须一样 | 相同                             | 子类重写方法，返回的类型和父类返回的<br />类型一致，或者是其子类 | 子类方法不能缩小<br />父类方法的访问范围 |

### 面向对象编程-多态

- 多态(Polymorphic)：多态是建立在封装和继承基础之上的，面向对象的第三大特征。
- 多态的具体体现

1. 方法的多态：
   1. 方法的重载：通过传入不同的参数，实现对不同方法的调用
   2. 方法的重写：通过不同对象调用，实现调用不同的方法
2. **对象的多态**
   1. **一个对象的编译类型和运行类型可以不一致**
   2. **编译类型在定义对象时，就确定了，不能改变**
   3. **运行类型是可以变化的**
   4. **编译类型看定义时 `=`号的左边，运行类型看 `=`的右边**

- 多态注意事项和细节讨论
  - 多态的前提是：两个(类)存在继承关系
  - 多态的向上转型

1. 本质：父类的引用指向了子类的对象
2. 语法：`父类类型 引用名 = new 子类类型();`
3. 特点：编译类型看左边，运行类型看右边。
4. **可以调用父类中的所有成员(需遵循访问权限)；不能调用子类中特有成员；最终运行效果看子类的具体实现。**

- 多态的向下转型

1. 语法：`子类类型 引用名 = (子类类型) 父类引用;`
2. 只能强转父类的引用，不能强转父类的对象
3. 要求父类的引用必须指向的是当前目标类型的对象
4. 当向下转型后，就可以调用子类类型中的所有成员

```java
package com.hspedu.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        // 向上转型：父类的引用指向子类的对象
        Animal animal = new Cat();
        Object object = new Cat();  // 也可以

//        animal.catchMouse();  // 但是不能调用子类的特有成员，因为在编译阶段，能调用哪些成员，是由编译类型来决定的
        // 最终运行效果看子类(运行类型)的具体实现，即调用方法时，按照从子类(运行类型)开始查找方法
        // 然后调用，规则如之前方法调用规则一致
        animal.show();  // 可以调用父类的所有成员(遵循访问权限)
        animal.eat();   // 猫吃鱼；调用的子类方法
        animal.run();   // 运行时，方法调用看运行类型，先从子类 Cat 中查找方法
        animal.sleep();

        // 向下转型
        // (1) 将父类的引用，强转为子类类型。语法：子类类型 引用名 = (子类类型) 父类引用;
        Cat cat = (Cat) animal; // cat的编译类型是 Cat，运行类型是 Cat
        // 编译类型是 Cat 所以可以调用 catchMouse，运行类型是 Cat，所以从 Cat类开始查找方法
        cat.catchMouse();   // 猫抓老鼠；
        // (2) 要求父类的引用必须指向的是当前目标类型的对象
//        Dog dig = (Dog) animal; // 错误，animal指向的不是目标类型 Dog 的对象
        System.out.println("OK~");
    }
}
```

- 多态的注意事项和细节讨论

  - 属性没有重写之说！属性的值看编译类型
  - `instance of`比较操作符，用于判断对象的类型是否为XX类型或XX类型的字类型。`a instanceof A`：判断a的**运行类型**是否是A！

  ```java
  public class PolyDetail02 {
      public static void main(String[] args) {
          // 属性没有继承之说！属性的值看编译类型
          Base base = new Sub();
          System.out.println("base.count=" + base.count); // base.count=10
          Sub sub = new Sub();
          System.out.println("sub.count=" + sub.count);   // sub.count=20
      }
  }
  class Base {
      int count = 10;
  }

  class Sub extends Base {
      int count = 20;
  }
  ```

```java
public class PolyDetail03 {
    public static void main(String[] args) {
        // a instanceof A ：判断 a 是否是 A类型或者A类型的字类型
        BB bb = new BB();
        System.out.println("bb instanceof BB: " + (bb instanceof BB));   // true
        System.out.println("bb instanceof AA: " + (bb instanceof AA));   // true

        // 是编译类型还是运行类型？ -> 运行类型！
        AA aa = new BB();
        System.out.println("aa instanceof BB: " + (aa instanceof BB));   // true
        System.out.println("aa instanceof AA: " + (aa instanceof AA));   // true

        Object obj = new Object();
        System.out.println("obj instanceof AA: " + (obj instanceof AA));   // false
        String str = "Hello";
        System.out.println("str instanceof Object: " + (str instanceof Object));  // true
    }
}

class AA { }
class BB extends AA { }
```

- **java的动态绑定机制(非常非常重要)**

1. 当调用对象方法的时候，该方法会和该对象的**内存地址/运行类型**绑定
2. **当调用对象属性时，没有动态绑定机制，哪里声明，哪里**使用。`2023-10-13:P316`

```java
package com.hspedu.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        // a 的编译类型是 A，运行类型是 B
        A a = new B();  // 向上转型
        /*
        1. 当调用对象方法时，该方法会和该对象的内存地址/运行类型绑定
        2. 当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
         */
        System.out.println("a.sum(): " + a.sum());  // a.sum(): 40 -> 30
        System.out.println("a.sum1(): " + a.sum1());    // a.sum1(): 30 -> 20
        System.out.println("a.i: " + a.i);    // 10，属性不会继承，调用属性时根据编译类型来
    }
}

class A {
    public int i = 10;
    // 动态绑定
    public int sum() {
        return getI() + 10; // 20 + 10 -> 30
    }
    public int sum1() {
        return i + 10;  // 10 + 10 -> 20
    }
    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;
//    public int sum() {
//        return i + 20;
//    }
    public int getI() {
        return i;
    }
//    public int sum1() {
//        return i + 10;
//    }
}
```

多态数组

- 数组的定义类型为父类类型，里面保存的实际元素类型为子类类型。

多态实参

- 方法定义的形参类型为父类型，实参类型允许子类类型

### Object类详解

- `equal`方法：`==`和 `equals`的对比

1. **`==`：既可以判断基本类型，又可以判断引用类型**
2. **`==`：如果判断基本类型，判断的是值是否相等。**
3. **`==`：如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象。**
4. **`equals`：是 `Object`类中的方法，只能判断引用类型**
5. **默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等。**

```java
package com.hspedu.object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        // ==：对于引用类型，判断的是不是同一个对象
        System.out.println(a == c); // true
        System.out.println(b == c); // true

        B obj = a;  // 虽然编译类型不同，但是指向的内存地址相同
        System.out.println(obj == a);   // true

        // ==：对于基本类型，判断的是值是否相等
        int num1 = 10;
        double num2 = 10.0;
        System.out.println(num1 == num2);   // true

        // 查看实现/原码：ctrl + b
        // equals()只能判断引用类型，默认判断的是地址是否相等
        "Hello".equals("hello");
/*
    public boolean equals(Object anObject) {
        if (this == anObject) { // 如果是同一个对象(地址相同)
            return true;        // 返回 true
        }
        if (anObject instanceof String) {   // 判断类型
            String anotherString = (String)anObject;    // 向下转型
            int n = value.length;
            if (n == anotherString.value.length) {  // 如果长度相同
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {  // 一个一个比较字符
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;    // 如果两个字符串的所有字符都相等，则返回true
            }
        }
        return false;
    }
 */
        Integer i = new Integer(100);
        Integer i1 = new Integer(100);
        System.out.println(i == i1);    // false    引用类型，判断的是否为同一对象
        System.out.println(i.equals(i1));   // true 重写equals方法，先判断是否为同一类型，再判断值是否相等
        System.out.println(i.equals(100.));   // false 类型不同，直接返回false

        String str1 = new String("Charlie");
        String str2 = new String("Charlie");
        System.out.println(str1 == str2);   // 引用类型，判断地址不同，返回 false
        System.out.println(str1.equals(str2));  // true 值相同
    }
}

class B {}
class A extends B {}
```

- `hashCode()`方法

1. 提高具有哈希结构的日期的效率！
2. 两个引用，如果指向同一个对象，则哈希值是一样的！
3. 两个引用，如果指向的是不同对象，则哈希值是不一样的
4. 哈希值主要根据地址号来的！不能完全将哈希值等价于地址
5. 后面在集合中 `hashCode`如果需要的话，也会重写

```java
public class HashCode {
    public static void main(String[] args) {
        AA aa = new AA();
        AA aa2 = new AA();
        AA aa3 = aa;
        System.out.println("aa.hashCode()=" + aa.hashCode());   // 460141958
        System.out.println("aa2.hashCode()=" + aa2.hashCode()); // 1163157884
        System.out.println("aa3.hashCode()=" + aa3.hashCode()); // 460141958
    }
}
class AA {}
```

- `toString()`方法

1. 默认返回：全类名+`@`+哈希值的十六进制。全类名包含包名
2. 子类往往会重写 `toString`方法，用于返回对象的属性信息
3. 当直接输出一个对象时，`toString`方法会被默认调用

```java
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
```

- `finalize`方法

1. 当对象被回收时，系统自动调用该对象的 `finalize`方法。子类可以重写该方法，做一些**释放资源**的操作
2. 什么时候被回收：当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用 `finalize`方法
3. 垃圾回收机制的调用，是由系统来决定的，也可以通过 `System.gc()`主动触发垃圾回收机制

### 断点调试

1. 在断点调试过程中，是**运行状态**，是以对象的**运行类型**来执行的 `2023-10-15:P331`

| 快捷键       | 功能                     |
| ------------ | ------------------------ |
| `F7`       | 跳入方法内               |
| `F8`       | 跳过                     |
| `shift+F8` | 跳出方法                 |
| `F9`       | resume，执行到下一个断点 |

> 既可以在本文件下断点，也可以在系统文件下断点
>
> 可以动态地下断点

| 访问修饰符    | 本类 | 同包 | 子类 | 不同包 |
| ------------- | ---- | ---- | ---- | ------ |
| `public`    | √   | √   | √   | √     |
| `protected` | √   | √   | √   | ×     |
| `默认`      | √   | √   | ×   | ×     |
| `private`   | √   | ×   | ×   | ×     |


> 1.说出 `==`和 `equals`的区别？
>
> - `==`是比较运算符。既可以用于基本数据类型，也可以用于引用类型。对基本类型，判断值是否相等；对引用类型，判断是否为同一个对象的引用。
> - `equals`是 `Object`类中的方法。不能用于基本数据类型，只用于判断是否为同一个对象的引用，一般在自定义类型时都会重写该方法。
>
> 2.什么是多态，多态具体体现有哪些？
>
>> 方法或对象具有多种形态，是OOP的第三大特征，是建立在封装和继承基础之上。多态具体体现：
>>
>> 1. 方法多态：
>>    1. 重载体现多态
>>    2. 重写体现多态
>> 2. 对象多态
>>    1. 对象的编译类型和运行类型可以不一致，编译类型在定义时，就确定，不能变化。
>>    2. 对象的运行类型是可以变化的，可以通过 `getClass()`查看运行类型
>>    3. 编译类型看定义时 `=`的左边，运行类型看 `=`的右边。
>>
>
> 3. `java`的多态绑定机制是什么？
>
>> 1. 当调用对象的**方法**时，该方法会和对象的**内存地址/运行类型**绑定。
>> 2. 当调用对象的**属性**时，没有动态绑定机制，遵守“哪里声明，那里使用”。
>>

1

## END
