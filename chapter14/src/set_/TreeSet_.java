package set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        // 1. 当使用无参构造器，创建 TreeSet时，仍然是无序的
        // 2. 希望添加的元素，按照字符串大小排序
        // 3. 使用 TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)
        //      并指定排序规则
        // 4. 源码
        TreeSet<Object> treeSet = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                // 下面调用 String的 CompareTo方法 进行字符串大小比较
//                return ((String) o2).compareTo((String) o1);
                return ((String) o1).length() - ((String) o2).length(); // 按字符串长度比较
            }
        });
        // 添加数据
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("js");
        treeSet.add("c");
        treeSet.add("cpp"); // 按长度比较不会加入，因为 cpp 长度和 tom 长度相同
        System.out.println("treeSet=" + treeSet);   // treeSet=[c, js, tom, jack]
        /*
        1. 构造器把传入的比较器对象，赋值给了 TreeSet 底层的 TreeMap 的属性 this.comparator
            public TreeSet(Comparator<? super E> comparator) {
                this(new TreeMap<>(comparator));
            }
        2. 在调用 add方法 时在底层会执行到
                if (cpr != null) {  // cpr 就是自定义的匿名内部类(对象)
                    do {
                        parent = t;
                        cmp = cpr.compare(key, t.key);  // 动态绑定到匿名内部类的compare
                        if (cmp < 0)
                            t = t.left;
                        else if (cmp > 0)
                            t = t.right;
                        else    // 如果相等，即cmp为0，则不会添加元素
                            return t.setValue(value);
                    } while (t != null);
                }
         */
    }
}
