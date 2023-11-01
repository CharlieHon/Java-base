package collection_;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection<Object> col = new ArrayList<>();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("倚天屠龙记", "金庸", 12.1));
        col.add(new Book("天龙八部", "金庸", 15.2));
        // 1. 使用增强 for
        // 2. 底层仍然是迭代器
        // 3. 增强for可以理解为简化版本的迭代器
        // 4. 快捷方式 I
        for (Object obj :
                col) {
            System.out.println(obj);
        }
        // 增强for，也可以直接在数组上使用
        int[] nums = {1, 8, 9, 5};
        for (int x :
                nums) {
            System.out.print(x + " ");
        }
    }
}
