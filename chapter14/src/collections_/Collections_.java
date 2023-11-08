package collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {
    public static void main(String[] args) {
        /*
         * `reverse(List)`：反转List中元素的排序
         * `shuffle(List)`：对List集合元素进行随机排序
         * `sort(List)`：根据元素的自然顺序对指定List集合元素按升序排序
         * `sort(List, Comparator)`：根据指定的Comparator产生的顺序对List集合元素进行排序
         * `swap(List, i, j)`：将指定List集合中的i处元素和j处元素进行交换
         */
        // 创建 ArrayList 用于测试
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("jack");
        list.add("bruce");
        list.add("king");
        list.add("charlie");
        System.out.println("list=" + list); // list=[tom, jack, bruce, king, charlie]
        // 1. 反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println("list=" + list); // list=[charlie, king, bruce, jack, tom]
        // 2. 随机打乱 List 中元素的顺序
        Collections.shuffle(list);
        System.out.println("list=" + list); // 每次结果都不一样
        // 3. `sort(List)`：根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(list);
        System.out.println("自然排序：list=" + list);    // list=[bruce, charlie, jack, king, tom]
        // 4. `sort(List, Comparator)`：根据指定的Comparator产生的顺序对List集合元素进行排序
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                // 按照字符串长度大小排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("按字符串长度排序：" + list); // [tom, jack, king, bruce, charlie]
        // 5. `swap(List, i, j)`：将指定List集合中的i处元素和j处元素进行交换
        Collections.swap(list, 0, 1);
        System.out.println("交换后：" + list);  // [jack, tom, king, bruce, charlie]

    }
}
