package chapter09.houserent;

import chapter09.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        // 创建HouseView对象，并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("=======你已退出房屋出租系统=======");
    }
}
