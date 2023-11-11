package exercise_;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<User> users = new DAO<>();
        users.save("1001", new User(1, 25, "张三"));
        users.save("1002", new User(2, 18, "李四"));
        users.save("1003", new User(3, 28, "王五"));
        System.out.println(users.get("1002"));
        users.update("1002", new User(2, 22, "李自成"));
        System.out.println(users);
        List<User> list = users.list();
        for (User user : list) {
            System.out.println(user);
        }
        users.delete("1001");
        System.out.println("OK~");
    }
}

class DAO<T> {
    private Map<String, T> mp = new HashMap<>();
    public void save(String id, T entity) { // 保存 T 类型的对象到 map 成员变量中
        mp.put(id, entity);
    }

    public T get(String id) {   // 从 map 中获取 id 对应的对象
        return mp.get(id);
    }

    public void update(String id, T entity) {   // 替换 map 中 key 为 id 的内容，改为 entity 对象
        mp.put(id, entity);
    }

    public List<T> list() { // 返回 map 中存放的所有 T 对象
        // 创建列表
        List<T> res = new ArrayList<>();
        // 遍历mp
        Set<String> set = mp.keySet();
        for (String id : set) {
            // get(id) 返回类型是 User
            res.add(get(id));   // get() 方法即本类自定义的方法
        }
        return res;
    }

    public void delete(String id) { // 删除指定对象
        mp.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "mp=" + mp +
                '}';
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ": " + name + "-" + age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}