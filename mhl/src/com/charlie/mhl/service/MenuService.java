package com.charlie.mhl.service;

import com.charlie.mhl.dao.MenuDAO;
import com.charlie.mhl.domain.Menu;

import java.util.List;

/**
 * 完成对 menu表的操作，通过调用 MenuDAO完成
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    // 返回所有的菜品
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu ", Menu.class);
    }

    // 根据id，返回Menu对象
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id=?", Menu.class, id);
    }
}
