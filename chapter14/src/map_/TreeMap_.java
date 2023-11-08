package map_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        // 使用默认构造器，创建 TreeMap，是无序的(也没有排序)
//        TreeMap<Object, Object> treeMap = new TreeMap<>();
        TreeMap<Object, Object> treeMap = new TreeMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length(); // 按照字符串长度排序
//                return ((String) o1).compareTo((String) o2); // 按照字符串大小进行比较
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("smith", "史密斯");
        treeMap.put("bruce", "布鲁斯");    // 与上一个长度相同，将上一个的值进行更改
        // 默认：treeMap={bruce=布鲁斯, jack=杰克, smith=史密斯, tom=汤姆}
        System.out.println("treeMap=" + treeMap);   // 长度：treeMap={tom=汤姆, jack=杰克, smith=布鲁斯}
        /*
        // 1. 构造器 把传入的实现了 Comparator接口的匿名内部类(对象)，传给TreeMap的comparator属性
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
            2. 调用 put 方法
            2.1 第一次添加，把k-v封装到Entry对象，放入到 root
                    Entry<K,V> t = root;
                    if (t == null) {
                        // 检测传入的key是否为空
                        compare(key, key); // type (and possibly null) check

                        root = new Entry<>(key, value, null);
                        size = 1;
                        modCount++;
                        return null;
                    }
            2.2 第二次，进行比较
                    Comparator<? super K> cpr = comparator;
                    if (cpr != null) {
                        do {    // 遍历所有的key，给当前key找到适当位置
                            parent = t;
                            cmp = cpr.compare(key, t.key);  // 动态绑定到匿名内部类的compare方法
                            if (cmp < 0)
                                t = t.left;
                            else if (cmp > 0)
                                t = t.right;
                            else    // 如果遍历过程中，返现准备添加的key和当前已有的key相等(自定义比较)，就不添加
                                return t.setValue(value);
                        } while (t != null);
                    }
         */
    }
}
