package com.charlie.mhl.service;

import com.charlie.mhl.dao.EmployeeDAO;
import com.charlie.mhl.domain.Employee;

/**
 * 业务层，该类完成对 employee表的操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {
    // 定义一个 EmployeeDAO 属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    // 方法，更具 empId和pwd 返回一个 Employee对象
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)",
                Employee.class, empId, pwd);
    }
}
