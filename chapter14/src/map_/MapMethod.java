package map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        /*
        1. put: 添加
        2. remove: 根据键删除映射关系
        3. get: 根据键取值
        4. size: 获取元素个数
        5. isEmpty: 判断个数是否为0
        6. clear: 清除
        7. containsKey: 查找键是否存在
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

        map.remove(null);   // 根据键删除映射关系
        System.out.println("map=" + map);
        Object val = map.get("李自成");
        System.out.println("val=" + val);   // 崇祯
        System.out.println("k-v=" + map.size());    // 5
        System.out.println(map.isEmpty());  // false
        System.out.println(map.containsKey("hsp")); // false 查找键是否存在
        map.clear();    // 清空
    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}