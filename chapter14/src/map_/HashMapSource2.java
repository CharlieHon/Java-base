package map_;

import java.util.HashMap;

public class HashMapSource2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 12; i++) {
            hashMap.put(new A(i), "hello");
        }
        System.out.println("hashMap=" + hashMap);
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() { // 所有的A对象的hashCode都相同
        return 100;
    }

    @Override
    public String toString() {
        return num + "";
    }
}
