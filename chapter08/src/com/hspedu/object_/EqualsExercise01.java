package com.hspedu.object_;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person person = new Person("Charlie", 18, '男');
        Person person1 = new Person("Charlie", 18, '男');
        System.out.println(person == person1);  // false
        System.out.println(person.equals(person1)); // true
    }
}
class Person {  // extends Object
    private String name;
    private int age;
    private char gender;

    public Person() {}

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }



    // 重写方法 equals
    public boolean equals(Object obj) {
        if (this == obj) {    // 是同一对象，直接返回 true
            return true;
        }
        // 类型判断
        if (obj instanceof Person) {    // 类型相同，判断所有属性是否相同
            // 向下转型，因为需要得到 obj 的各个属性
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;    // 所有属性值都一样，返回true
        }
        // 如果不是 Person，则直接返回false
        return false;
    }

}