package com.charlie.mhl.view;

import com.charlie.mhl.domain.*;
import com.charlie.mhl.service.BillService;
import com.charlie.mhl.service.DiningTableService;
import com.charlie.mhl.service.EmployeeService;
import com.charlie.mhl.service.MenuService;
import com.charlie.mhl.utils.Utility;

import java.util.List;

/**
 * 满汉楼主界面
 */
public class MHLView {
    // 控制是否退出菜单
    private boolean loop = true;
    private String key = "";    // 接收用户输入
    // 定义 EmployeeService 对象
    private EmployeeService employeeService = new EmployeeService();
    // 定义 DiningTableService 对象
    private DiningTableService diningTableService = new DiningTableService();
    // 定义 MenuService 对象
    private MenuService menuService = new MenuService();
    // 定义 BillService 对象
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().showMenu();
    }

    // 显示主菜单
    public void showMenu() {
        while (loop) {
            System.out.println("=================满汉楼=================");
            System.out.println("\t\t 1. 登录满汉楼");
            System.out.println("\t\t 2. 退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密　码：");
                    String pwd = Utility.readString(50);
                    // 到数据库去判断
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) { // 返回非空，说明该用户存在
                        System.out.println("=================(" + employee.getName() + ")登陆成功=================\n");
                        // 显示二级菜单，这里二级菜单是循环操作，所以做成while
                        while (loop) {
                            System.out.println("=================满汉楼二级菜单=================");
                            System.out.println("\t\t 1. 显示餐桌状态");
                            System.out.println("\t\t 2. 预定餐桌");
                            System.out.println("\t\t 3. 显示所有菜品");
                            System.out.println("\t\t 4. 点餐服务");
                            System.out.println("\t\t 5. 查看账单");
                            System.out.println("\t\t 6. 结账");
                            System.out.println("\t\t 9. 退出满汉楼");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    getDiningTableState();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    System.out.println("您退出满汉楼~");
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入！");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("=================登陆失败=================\n");
                    }
                    break;
                case "2":
                    System.out.println("您退出满汉楼~");
                    loop = false;
                    break;
                default:
                    System.out.println("请按照格式正确输入！");
                    break;
            }
        }
    }

    // 1. 显示所有餐桌状态
    public void getDiningTableState() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("=================显示完毕=================");
    }

    // 2. 完成预定餐桌
    public void orderDiningTable() {
        System.out.println("=================预定餐桌=================");
        System.out.print("请输入餐桌编号(-1退出):");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("=================取消预定=================");
            return;
        }
        // 该方法得到是 Y 或者是 N
        char c = Utility.readConfirmSelection();
        if (c == 'Y') { // 要预定
            // 根据orderId返回对应的DiningTable对象
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if (diningTable == null) {  // 如果为null，表示该餐桌不存在
                System.out.println("=================预定的餐桌不存在！=================");
                return;
            }
            if (!"空".equals(diningTable.getState())) {  // 餐桌状态非空
                System.out.println("=================该餐桌已被预定/就餐中=================");
                return;
            }
            // 到这里表示可以预定
            System.out.print("预定人姓名：");
            String orderName = Utility.readString(16);
            System.out.print("预定人电话：");
            String orderTel = Utility.readString(16);
            // 更新餐桌状态
            if (diningTableService.updateDiningTableState(orderId, orderName, orderTel)) {
                System.out.println("=================预定餐桌成功！=================");
            } else {
                System.out.println("=================预定餐桌失败~=================");
            }
        } else {
            System.out.println("=================取消预定=================");
        }
    }

    // 3. 显示所有菜品
    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名称\t\t类型\t\t单价");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("=================显示完毕=================");
    }

    // 4. 完成点餐
    public void orderMenu() {
        System.out.println("=================点餐服务=================");
        System.out.print("请输入点餐的桌号(-1退出)：");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("=================取消点餐=================");
            return;
        }
        System.out.print("请输入菜品的编号(-1退出)：");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("=================取消点餐=================");
            return;
        }
        System.out.print("请输入点餐的菜品量(-1退出)：");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("=================取消点餐=================");
            return;
        }

        // 验证餐桌号是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("=================餐桌号不存在=================");
            return;
        }
        // 验证菜品编号是否正确
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("=================菜品号不存在=================");
            return;
        }

        // 点餐
        if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("=================点餐成功=================");
        } else {
            System.out.println("=================点餐失败=================");
        }
    }

    // 5. 显示账单信息
    public void listBill() {
//        List<Bill> bills = billService.list();
//        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
//        for (Bill bill : bills) {
//            System.out.println(bill);
//        }

        // 进行多表查询，返回菜品名称
        List<MultiTableBean> multiTableBeans = billService.list2();
        System.out.println("\n编号\t\t菜品名称\t\t菜品量\t\t金额\t\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (MultiTableBean multiTable : multiTableBeans) {
            System.out.println(multiTable);
        }
        System.out.println("=================显示完毕=================");
    }

    // 6. 完成结账
    public void payBill() {
        System.out.println("=================结账服务=================");
        System.out.print("请选择要结账的餐桌编号(-1退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("=================取消结账=================");
            return;
        }
        // 验证餐桌是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
        if (diningTable == null) {
            System.out.println("=================结账的餐桌不存在=================");
            return;
        }
        // 验证存在是否存在需要结账的账单
        if (!billService.hasPayBillByDiningTableId(diningTableId)) {
            System.out.println("=================该餐桌没有未结账账单=================");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信)回车表示退出：");
        String payMode = Utility.readString(20, "");    // 说明：如果回车，就是返回 ""
        if ("".equals(payMode)) {
            System.out.println("=================取消结账=================");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            // 调用之前写的方法
            if (billService.payBill(diningTableId, payMode)) {
                System.out.println("=================完成结账=================");
            } else {
                System.out.println("=================结账失败=================");
            }
        } else {
            System.out.println("=================取消结账=================");
        }

    }
}
