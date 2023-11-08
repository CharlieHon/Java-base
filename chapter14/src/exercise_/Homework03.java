package exercise_;

import java.util.*;

public class Homework03 {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        Employee jack = new Employee("jack", 650);
        Employee tom = new Employee("tom", 1200);
        Employee smith = new Employee("smith", 2900);
        m.put(jack.getName(), jack.getSalary());
        m.put(tom.getName(), tom.getSalary());
        m.put(smith.getName(), smith.getSalary());
        Set<String> set = m.keySet();
        for (String name :
                set) {
            System.out.println(name + "-" + m.get(name));
        }
        // 将 jack 的工资更改为 2600
        m.put("jack", 2600);
        System.out.println(m);  // {tom=1200, smith=2900, jack=2600}
        // 将所有员工工资加新 100
        Set<Map.Entry<String, Integer>> entries = m.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            m.put(entry.getKey(), entry.getValue() + 100);
        }
        System.out.println(m);  // {tom=1300, smith=3000, jack=2700}
        // 遍历集合中所有的员工
        // 遍历集合中所有的工资
        Collection<Integer> values = m.values();
        for (int salary :
                values) {
            System.out.println(salary);
        }
    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "-" + salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}