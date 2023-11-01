package exercise_;

import java.util.List;
import java.util.Map;

public class Homework01 {
    public static void main(String[] args) {
        System.out.println("OK~");
    }
}

//class DAO<T> {
//    private Map<String, T> mp;
//    public void save(String id, T entity) { // 保存 T 类型的对象到 map 成员变量中
//
//    }
//
//    public T get(String id) {   // 从 map 中获取 id 对应的对象
//
//    }
//
//    public void update(String id, T entity) {   // 替换 map 中 key 为 id 的内容，改为 entity 对象
//
//    }
//
//    public List<T> list() { // 返回 map 中存放的所有 T 对象
//
//    }
//
//    public void delete(String id) { // 删除指定对象
//
//    }
//}

class User {
    private int id;
    private int age;
    private String name;
}