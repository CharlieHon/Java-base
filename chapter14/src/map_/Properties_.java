package map_;

import java.io.PrintStream;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {
        // 1. Properties 继承 HashTable 类
        // 2. 可以通过键值对 K-V 存放数据，key和value都不能为 null
        // 3.
        Properties properties = new Properties();
//        properties.put(null, "abc");    // NullPointerException
//        properties.put("abc", null);  // 同上
        properties.put("john", 100);
        properties.put("lucy", 100);
        properties.put("bruce", 100);
        properties.put("bruce", 200);   // 如果有相同的key，value被替换
        System.out.println("properties=" + properties); // properties={bruce=200, john=100, lucy=100}
        // 通过k，获取对应的值
        System.out.println(properties.get("bruce"));    // 200
        System.out.println(properties.getProperty("bruce"));    // null
        // 删除
        properties.remove("bruce");
        System.out.println("properties=" + properties); // properties={john=100, lucy=100}
        // 修改
        properties.put("john", "约翰");   // 添加键相同的元素，就可视为修改
        System.out.println("properties=" + properties); // properties={john=约翰, lucy=100}
    }
}
