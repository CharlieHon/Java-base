package generic_;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        // 使用泛型方式给 HashSet 放入3个学生对象
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 19));
        students.add(new Student("marry", 20));
        // 遍历
        for (Student student :
                students) {
            System.out.println(student.toString());
        }

        // 使用泛型方式给 HashMap 存放3个学生对象
        HashMap<String, Student> hm = new HashMap<>();
        hm.put("jack", new Student("jack", 18));
        hm.put("tom", new Student("tom", 18));
        hm.put("smith", new Student("smith", 18));
        // 迭代器 EntrySet
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}