package chapter09.houserent.service;

import chapter09.houserent.domain.House;

/**
 * HouseService.java <=> 业务层
 * 定义 House[] 保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */
public class HouseService {
    private House[] houses; // 保存House对象
    private int houseNums = 1;  // 记录当前有多少个房屋信息
    private int idCounter = 1;  // 记录当前id增长到哪个值

    public HouseService(int size) {
        // 当创建HouseService对象时，指定数组大小
        houses = new House[size];
        // 为了便于测试，初始化一个House对象
        houses[0] = new House(1, "Bruce", "112", "海淀区", 2000, "未出租");
    }

    // list方法，返回houses
    public House[] list() {
        return houses;
    }

    // add(House newHouse) 把新的 house对象 加入到 houses数组，返回 bool
    public boolean add(House newHouse) {
        // 判断是否还可以继续添加(暂时不考虑数组扩容问题)
        if (houseNums >= houses.length) {
            // 不能再添加
//            System.out.println("数组已满，不能再添加");
            // 数组扩容
            System.out.println("数组扩容");
            // 开辟新空间
            House[] newHouses = new House[houseNums+1];
            for (int i = 0; i < houses.length; i++) {
                newHouses[i] = houses[i];
            }
            newHouses[houseNums++] = newHouse;
            houses = newHouses;
            newHouse.setId(++idCounter);
            return false;
        }
        // 把newHouse对象加入到数组
        houses[houseNums++] = newHouse;
        // 需要设计一个id自增长机制，更新newHouse的id
        newHouse.setId(++idCounter);
        return true;
    }

    // del(int delId) 删除指定id的房屋
    public boolean del(int delId) {
        // 以下注释写法不对！！！
//        if (delId > idCounter || delId <= 0) {
//            return false;
//        }

        int index = -1;
        for (int i = 0; i < houseNums; i++) {   // 删除后 houseNums改变，但是 houses.length 不变
            if (houses[i].getId() == delId) {   // 要删除的房屋(di)，是数组下标为i的元素
                index = i;
            }
        }

        if (index == -1) {
            // 说明 delId 在数组中不存在
            return false;
        }

        // 最多移动到 houseNus - 1
        // houses[houseNums - 1] = houses[houseNums];
        for (int i = index; i < houseNums - 1; ++i) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null; // 置空，当遍历为空时，结束
        return true;
    }

    // find方法，返回House对象或者null
    public House searchId(int sId) {
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == sId) {
                return houses[i];
            }
        }
        return null;
    }
}
