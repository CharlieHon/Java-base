package generic_;

import java.util.ArrayList;

public class Generic02 {
    public static void main(String[] args) {
        // 1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是 Dog 类型
        // 2. 如果编译器发现添加的类型不满足要求，就会报错
        // 3. 遍历的时候，可以直接取出 Dog 类型，而不是 Object
        // 4. public class ArrayList<E> {} E称为泛型，那么 Dog -> E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        // 假如不小心加入其它类 Cat
//        arrayList.add(new Cat("招财猫", 3));
        for (Dog dog :
                arrayList) {
            System.out.println(dog.getName() + ", " + dog.getAge());
        }
    }
}
