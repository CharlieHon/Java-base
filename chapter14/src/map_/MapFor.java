package map_;

import java.util.*;

import java.util.Map;
import java.util.HashMap;

public class MapFor {
    public static void main(String[] args) {
        // Map接口遍历方式
        /*
        1. containsKey: 查找键是否存在
        2. keySet: 获取所有的键
        3. entrySet: 获取所有关系k-v
        4. values: 获取所有值
         */
        Map<Object, Object> map = new HashMap<>();
        map.put("李自成", new Book("大明", 1000));
        map.put("李自成", "崇祯");   // 替换↑
        map.put("李白", "杜甫");
        map.put("王宝强", "傻根");
        map.put("李世民", null);
        map.put(null, "武则天");
        map.put("杨过", "小龙女");
        System.out.println("map=" + map);   // map={null=武则天, 杨过=小龙女, 李白=杜甫, 李世民=null, 王宝强=傻根, 李自成=崇祯}

        // 1. 先取出所有的key，再通过key取出对应的value
        Set<Object> keyset = map.keySet();
        // (1) 增强for
        System.out.println("===方式一：keySet() + foreach===");
        for (Object key :keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        // (2) 迭代器
        System.out.println("===方式二: keySet() + iterator()===");
        Iterator<Object> iter = keyset.iterator();
        while (iter.hasNext()) {
            Object key =  iter.next();
            System.out.println(key + "-" + map.get(key));
        }

        // 2. 把所有的values取出
        Collection<Object> values = map.values();
        // 这里可以使用所有Collection使用的遍历方式
        // 没有 get() 方法，用不了 for循环

        // 3. 通过 EntrySet 获取 k-v
        System.out.println("===方式三：entrySet() + foreach");
        Set<Map.Entry<Object, Object>> set = map.entrySet();
        for (Object obj : set) {
            // 将 obj 向下转型为 Map.Entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println("===方式四: entrySet() + iterator()===");
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            // iterator.next() 实际上是 HashMap$Node 类型(运行类型)，实现了 Map.Entry 接口
            Map.Entry<Object, Object> entry = iterator.next();  // 转为 Map.Entry 接口，是因为该结构实现了两个高效方法
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
