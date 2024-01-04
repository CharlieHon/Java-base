package com.charlie.mhl.service;

import com.charlie.mhl.dao.BillDAO;
import com.charlie.mhl.dao.MultiTableDAO;
import com.charlie.mhl.domain.Bill;
import com.charlie.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    // 定义 BillDAO 属性
    private BillDAO billDAO = new BillDAO();
    // 定义 MenuService 属性
    private MenuService menuService = new MenuService();
    // 定义 DiningTableService 属性
    private DiningTableService diningTableService = new DiningTableService();

    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    /**
    编写点餐操作
    *    1. 生成账单
    *    2. 需要更新对应餐桌的状态
    *    3. 如果成功返回 true，否则返回 false
     */
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        // 生成一个账单号，UUID
        String billId = UUID.randomUUID().toString();
        double money = menuService.getMenuById(menuId).getPrice() * nums;
       // 将账单生成到bill表
        int update = billDAO.update("insert into bill values (null, ?, ?, ?, ?, ?, now(), '未结账')",
                billId, menuId, nums, money, diningTableId);
        if (update <= 0) {
            return false;
        }
        // 更新餐桌状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    /**
     * 返回所有的账单，提供给view调用
     */
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    /**
     * 返回所有的账单，使用菜品名称替代菜品的id
     */
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("SELECT bill.id, `name`, nums, money, diningTableId, billDate, state\n" +
                "\tFROM bill, menu\n" +
                "\tWHERE bill.menuId=menu.id", MultiTableBean.class);
    }

    /**
     * 查看某个餐桌号是否有未结账的账单
     */
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill = billDAO.querySingle("select * from bill where diningTableId=? and state='未结账' limit 0, 1",
                Bill.class, diningTableId);
        return bill != null;
    }

    /**
     * 完成结账，如果该餐桌存在，并且该餐桌有未结账的账单
     * 如果成功就返回true，否则false
     */
    public boolean payBill(int diningTableId, String payMode) {
        // 1. 修改bill表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);
        if (update <= 0) {  // 如果更新没有成功，表示失败
            return false;
        }
        // 2. 修改diningTable表->改变diningTable状态
        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }
}
