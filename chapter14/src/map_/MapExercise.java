package map_;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {
        HashMap<String, Employee> map = new HashMap<>();
        map.put("01", new Employee("张三", 20000, "01"));
        map.put("02", new Employee("李四", 21000, "02"));
        map.put("03", new Employee("王二", 17000, "03"));
        // 遍历
        System.out.println("===遍历1===");
        Set<String> set = map.keySet(); // keySet()
        for (String s : set) {
            if (map.get(s).getSalary() > 18000) {
                System.out.println(map.get(s));
            }
        }
        System.out.println("===遍历2===");
        Collection<Employee> collection = map.values();
        Iterator<Employee> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            if (next.getSalary() > 18000) {
                System.out.println(next);
            }
        }
        System.out.println("===遍历3===");
        Set<Map.Entry<String, Employee>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            Employee emp = (Employee) entry.getValue();
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private String id;

    public Employee(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}