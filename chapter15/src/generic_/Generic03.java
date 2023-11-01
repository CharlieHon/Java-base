package generic_;

public class Generic03 {
    public static void main(String[] args) {
        // E具体的数据类型在定义 Peron 对象时指定的，即在编译期间就确定E是什么类型
        // 相当于将 String 将所有 E 替换掉
        Person<String> stringPerson = new Person<String>("自由平等");
        stringPerson.show();    // class java.lang.String
        Person<Integer> integerPerson = new Person<>(100);
        integerPerson.show();   // class java.lang.Integer
    }
}

// 泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型。
class Person<E> {
    private E name; // E 表示 name 的数据类型，该数据类型是在定义 Peron 对象时指定的，即在编译期间就确定E是什么类型

    public Person(E name) { // E 也可以是参数类型
        this.name = name;
    }

    public E f() {  // 返回类型
        return name;
    }

    public void show() {
        System.out.println(name.getClass());    // 显示 name 数据类型
    }

}