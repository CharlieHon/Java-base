package list_;

import java.util.*;

public class ListFor {
    public static void main(String[] args) {
        // List 接口的实现子类：ArrayList, LinkedList, Vector
//        List<Object> list = new ArrayList<>();
//        List<Object> list = new LinkedList<>();
        List<Object> list = new Vector<>();
        list.add("慕容恪");
        list.add("慕容垂");
        list.add("拓跋珪");
        list.add("拓跋焘");
        // 遍历
        // 1. 迭代器
        System.out.println("===迭代器===");
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            Object o = iter.next();
            System.out.print(o + " ");
        }
        // 2. 增强for循环
        System.out.println("\n===增强for循环===");
        for (Object o : list) {
            System.out.print(o + " ");
        }
        // 3. 普通for循环
        System.out.println("\n===普通for循环===");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
