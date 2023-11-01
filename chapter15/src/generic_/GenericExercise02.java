package generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        Employee e1 = new Employee("tom", 300, new MyDate(1996, 5, 1));
        Employee e2 = new Employee("jack", 250, new MyDate(2001, 3, 14));
        Employee e3 = new Employee("tom", 400, new MyDate(1997, 10, 2));
        ArrayList<Employee> es = new ArrayList<>();
        es.add(e1);
        es.add(e2);
        es.add(e3);
        // 排序
        es.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 先对传入的参数进行验证
                if (!(o1 != null && o2 != null)) {
                    System.out.println("类型不能为空");
                    return 0;
                }
                if (!(o1.getName().equals(o2.getName()))) { // 名字不相同
                    return o1.getName().compareTo(o2.getName());
                }
//                return compareBirthday(o1, o2); // 比较生日
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        // 遍历
        for (Employee e :
                es) {
            System.out.println(e);
        }
    }

    public static int compareBirthday(Employee e1, Employee e2) {
        int y1 = e1.getBirthday().getYear(), y2 = e2.getBirthday().getYear();
        int m1 = e1.getBirthday().getMonth(), m2 = e2.getBirthday().getMonth();
        int d1 = e1.getBirthday().getDay(), d2 = e2.getBirthday().getDay();
        if (y1 != y2) {
            return y1 - y2;
        } else if (m1 != m2) {
            return m1 - m2;
        } else {
            return d1 - d2;
        }
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(MyDate otherDate) {    // 实现日期对象之间的比较
        if (year != otherDate.getYear()) {
            return year - otherDate.getYear();
        } else if (month != otherDate.getMonth()) {
            return month - otherDate.getMonth();
        } else {
            return day - otherDate.getDay();
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "员工：" + name + "，日薪：" + sal
                + "，生日：" + birthday.getYear() + '-' + birthday.getMonth() + '-' + birthday.getDay();
    }
}