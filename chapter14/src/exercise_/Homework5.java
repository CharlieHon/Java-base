package exercise_;

import com.sun.corba.se.impl.orb.PropertyOnlyDataCollector;

import java.util.HashSet;
import java.util.Objects;

public class Homework5 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1); // p1的hash值发生改变，然而之前存入的时候的hash索引不变，所以可能找不到而没有删除元素
        System.out.println(set);    // [1002-BB, 1001-CC]
        set.add(new Person(1001, "CC"));    // 此元素的 hash 与 修改后的p1 相同，而与set内的不同
        System.out.println(set);    // [1002-BB, 1001-CC, 1001-CC]
        set.add(new Person(1001, "AA"));    // 此元素 hash 与 修改前的p1相同，找到其索引，但是name改变，所以 equals() 返回false，可以加入
        System.out.println(set);    // [1002-BB, 1001-CC, 1001-CC, 1001-AA]
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}