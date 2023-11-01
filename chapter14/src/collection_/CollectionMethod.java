package collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /*
        add: 添加单个元素
        remove: 删除指定元素
        contains: 查找元素是否存在
        size: 获取元素个数
        isEmpty: 判断是否为空
        clear: 清空
        addAll: 添加多个元素
        containsAll: 查找多个元素是否都存在
        removeAll: 删除多个元素
        // 说明：以 ArrayList 实现类来演示
         */
        List list = new ArrayList();
        // add: 添加单个元素
        list.add("Bruce");
        list.add(10);   // 等价于 list.add(new Integer(10));
        list.add(true);
        System.out.println("list=" + list); // list=[Bruce, 10, true]
        // remove: 删除指定元素
        list.remove(0); // 删除第一个元素
        list.remove(true);  // 删除指定元素
        // contains: 查找元素是否存在
        System.out.println(list.contains("jack"));  // false
        // size: 获取元素个数
        System.out.println(list.size());    // 1
        // isEmpty: 判断是否为空
        list.clear();
        // addAll: 添加多个元素
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("红楼梦");
        objects.add("三国演义");
        list.addAll(objects);
        System.out.println("list=" + list); // list=[红楼梦, 三国演义]
        // containsAll: 查找多个元素是否都存在
        System.out.println(list.contains(objects)); // true
        // removeAll: 删除多个元素
        list.add("聊斋志异");
        list.removeAll(objects);
        System.out.println("list=" + list); // list=[聊斋志异]
    }
}
