package chapter09.houserent.view;

import chapter09.houserent.domain.House;
import chapter09.houserent.service.HouseService;
import chapter09.houserent.utils.Utility;

import javax.rmi.CORBA.Util;

/**
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用 HouseService 完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;    // 控制显示菜单
    private char key = ' '; // 接收用户选择
    private HouseService houseService = new HouseService(2);

    // 编写 updateHouse() 完成房屋修改功能
    public void updateHouse() {
        System.out.println("=================修改房屋=================");
        System.out.print("请选择修改房屋编号(-1退出)：");

        int uId = Utility.readInt();
        if (uId == -1) {
            System.out.println("=================放弃修改=================");
            return;
        }

        /*
        因为返回的house是引用类型，即数组的元素
        所以后面对 house.setXX() 就会修改 HouseService 中数组的元素！
         */
        House house = houseService.searchId(uId);
        if (house == null) {
            System.out.println("=================指定id房屋不存在=================");
            return;
        }

        System.out.print("姓名(" + house.getName() + ")");
        String name = Utility.readString(8, "");    // 如果用户直接回车表示不修改该信息，默认为 ""
        if (!"".equals(name)) { // 修改
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + ")");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + ")");
        String address = Utility.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + ")");
        int rent = Utility.readInt(house.getRent());
        house.setRent(rent);
        System.out.print("状态(" + house.getState() + ")");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
    }

    // 编写 search() 完成根据id查找房屋信息的功能
    public void search() {
        System.out.println("=================查找房屋=================");
        System.out.print("请输入查找的id：");
        int sId = Utility.readInt();
        // 调用方法
        House house = houseService.searchId(sId);
        if (house == null) {
            System.out.println("=================指定id房屋不存在=================");
        } else {
            System.out.println(house);
        }
    }

    // 完成退出确认
    public void exit() {
        // 使用工具类提供的方法，完成确认
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    // 编写 delHouse() 界面，接收用户输入
    public void delHouse() {
        System.out.println("=================删除房屋=================");
        System.out.print("请选择删除房屋编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            // 退出
            System.out.println("=================取消删除=================");
            return;
        }
        // 该方法本身就有循环判断的逻辑，必须输入Y/N
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("=================删除成功=================");
            } else {
                System.out.println("=================非法ID=================");
            }
        } else {
            System.out.println("=================删除取消=================");
        }
    }

    // 编写 addHouse() 界面，接收用户输入
    public void addHouse() {
        System.out.println("=================房屋列表=================");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        // 创建一个新的 house对象，注意id是系统分配的
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("=================添加成功=================");
        } else {
            System.out.println("=================添加失败=================");
        }
    }

    // 编写 listHouses() 界面，显示房屋列表
    public void listHouses() {
        System.out.println("=================房屋列表=================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();   // 得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {    // 数组中为null的都在最后部分
                break;  // 如果为空，就不再显示
            }
            System.out.println(houses[i]);
        }
        System.out.println("=================房屋列表显示完毕=================");
    }

    // 显示主菜单
    public void mainMenu() {
        do {
            System.out.println("=================房屋出租系统菜单=================");
            System.out.println("\t\t\t1. 新 增 房 源");
            System.out.println("\t\t\t2. 查 找 房 屋");
            System.out.println("\t\t\t3. 删 除 房 屋 信 息");
            System.out.println("\t\t\t4. 修 改 房 屋 信 息");
            System.out.println("\t\t\t5. 房 屋 列 表");
            System.out.println("\t\t\t6. 退      出");
            System.out.print("请输入你的选择(1~6)：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    search();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }
}
