package com.charlie.mhl.service;

import com.charlie.mhl.dao.DiningTableDAO;
import com.charlie.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    // 定义一个 DiningTableDAO 对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    // 返回所有餐桌信息
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id, state from diningTable", DiningTable.class);
    }

    // 根据id，查询对应的餐桌 DiningTable 对象
    // 如果返回 null，表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id) {
        return diningTableDAO.querySingle("select * from diningTable where id=?",
                DiningTable.class, id);
    }

    // 如果餐桌可以预定，调用方法对其状态进行更新(包括预定人的姓名和电话)
    public boolean updateDiningTableState(int id, String orderName, String orderTel) {
        // 返回受影响的行数，如果大于0，表示修改了表
        int update = diningTableDAO.update("update diningTable set state='已预定', orderName=?, orderTel=? where id=?",
                orderName, orderTel, id);
        return update > 0;
    }

    // 提供一个更新餐桌状态的方法
    public boolean updateDiningTableState(int id, String state) {
        return diningTableDAO.update("update diningTable set state=? where id=?", state, id) > 0;
    }

    // 将指定的餐桌设置为空闲状态
    public boolean updateDiningTableToFree(int id, String state) {
        return diningTableDAO.update("update diningTable set state=?, orderName='', orderTel='' where id=?", state, id) > 0;
    }
}
