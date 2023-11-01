package collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(new Dog("旺财", 3));
        list.add(new Dog("阿宝", 2));
        list.add(new Dog("阿星", 3));
        // 1. 迭代器
        Iterator<Object> iter = list.iterator();    // cursor: 0
        while (iter.hasNext()) {
            System.out.println(iter.next());    // 返回当前 cursor 指的内容，指向下一个
        }
        // 2. 增强for
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
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