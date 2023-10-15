package com.hspedu.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        // 多态数组
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("smith", 21, 100);
        persons[2] = new Student("bruce", 18, 92);
        persons[3] = new Teacher("tom", 29, 10000);
        persons[4] = new Teacher("john", 32, 15000);

        // 循环遍历多态数组，调用say方法
        for (int i = 0; i < persons.length; i++) {
            // person[i] 编译类型是 Person，运行类型是 根据实际情况由 JVM 来判断
            System.out.println(persons[i].say());   // 动态绑定机制
            if (persons[i] instanceof Student) {
                // 判断 persons[i] 运行类型是不是 Student
//                Student stu = (Student) persons[i]; // 向下转型
//                stu.study();
                ((Student)persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            } else if (persons[i] instanceof Person) {
//                System.out.println("类型有误，请检查...");
            } else {
                System.out.println("类型有误，请检查...");
            }
        }
    }
}
