package arraylist_;

import java.util.ArrayList;

public class ArrayListDetail {
    public static void main(String[] args) {
        // ArrayList 是线程不安全的，可以看源码没有 synchronized
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add("jack");
        System.out.println("arrayList=" + arrayList);

    }
}
