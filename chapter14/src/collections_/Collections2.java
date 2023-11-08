package collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections2 {
    public static void main(String[] args) {
        /*
        1. Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        2. Object min(Collection)
        3. Object min(Collection, Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        4. int frequency(Collection, Object)：返回指定集合中指定元素的出现次数
        5. void copy(List dest, List src)：将 src 中的内容赋值到 dest 中
        6. boolean replaceAll(List, Object oldVal, Object newVal)：使用新值替换 List 对象中旧值
         */
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("tom");
        list.add("jack");
        list.add("bruce");
        list.add("king");
        list.add("charlie");
        System.out.println("list=" + list); // list=[tom, tom,jack, bruce, king, charlie]
        System.out.println("自然顺序最大元素=" + Collections.max(list));    // tom
        // 返回字符串长度最大的元素
        System.out.println(Collections.max(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));    // charlie
        System.out.println("tom出现的次数：" + Collections.frequency(list, "tom"));   // 2
        ArrayList list1 = new ArrayList();
        // 为了完成拷贝，需要先给 list1 赋值，大小和 list.size() 一样
        for (int i = 0; i < list.size(); i++) {
            list1.add("");
        }
        Collections.copy(list1, list);  // 将 list 中内容拷贝到 list1
        System.out.println("list1=" + list1);   // list1=[tom, tom, jack, bruce, king, charlie]
        // 如果 list1 中有 tom，就替换为 汤姆
        Collections.replaceAll(list1, "tom", "汤姆");
        System.out.println("list1=" + list1);   //  list1=[汤姆, 汤姆, jack, bruce, king, charlie]
    }
}
