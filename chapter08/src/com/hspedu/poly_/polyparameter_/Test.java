package com.hspedu.poly_.polyparameter_;

public class Test {
    public static void main(String[] args) {
        Worker tom = new Worker("Tom", 2600);
        Manager bruce = new Manager("Bruce", 5000, 2000);
        Test test = new Test();
        test.showEmpAnnual(tom);
        test.showEmpAnnual(bruce);
        test.testWork(tom); // 普通员工 Tom is working.
        test.testWork(bruce);   // 经理 Bruce is managing.
    }

    public void showEmpAnnual(Employee e) { // 多态参数
        System.out.println(e.getAnnual());  // 动态绑定机制
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker)e).work();
        } else if (e instanceof Manager) {
            ((Manager)e).manage();
        }
    }

}
