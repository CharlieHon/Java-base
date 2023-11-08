package exercise_;

import java.util.TreeSet;

public class Homework4 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 试分析 HashSet 和 TreeSet 分别如何实现去重的
        /*
        1. HashSet 的去重机制：hashCode() + equals() 底层先通过存入对象，进行运算得到一个 hash值
            通过 hash值 得到对应的索引，如果发现 table 索引所在位置没有数据，就直接存放
            如果有数据，就进行 equals 比较，如果比较厚，不相同就加入，否则就不加入
        2. TreeSet 去重机制：如果传入了一个 Comparator 匿名对象，就使用实现的 compare 去重，
            如果方法返回 0，就认为是相同的元素/数据，就不添加。如果没有传入一个 Comparator 匿名对象
            则以添加对象实现的 Comparable 接口的 compareTo 去重
         */
        TreeSet treeSet = new TreeSet();
        treeSet.add("hsp");
        treeSet.add("tom");
        treeSet.add("king");
        treeSet.add("hsp"); // 默认操作 Comparable<? super K> k = (Comparable<? super K>) key;
                            //  cmp = k.compareTo(t.key);
        System.out.println(treeSet);    // [hsp, king, tom]
//        treeSet.add(new Person());  // 报错
        /*
        因为使用默认比价方式，必然会运行 Comparable<? super K> k = (Comparable<? super K>) key;
        而 Person 类没有实现 Comparable 接口，所以报错 ClassCastException
        如下实现 Comparable 接口，就不会报错了！
         */
    }
}

//class Person implements Comparable {
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}