package outputstream_;

import java.io.Serializable;

// 如果需要序列化某个对象，必须实现
public class Dog implements Serializable {
    private String name;
    private int age;
    // serialVersionUID 序列化的版本好，可以提高兼容性
    private static final long serialVersionUID = 1L;
    // static 和 transient 修饰的属性不会被序列化
    private static String nation;
    private transient String color;
    // 内部的属性也需要实现序列化接口
    private Master master = new Master();

    public Dog(String name, int age, String nation, String color) {
        this.name = name;
        this.age = age;
        this.nation = nation;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation + " " + master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}