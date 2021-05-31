package model.repository;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

    List<Employee> selectAllEmployee();

    boolean deleteEmployee(int id) throws SQLException;

    boolean updateEmployee(Employee Employee) throws SQLException;

    List<Employee> selectByName(String name) throws SQLException;


    Employee getEmployeeById (int id);

    void insertEmployeeStore(Employee Employee) throws SQLException;

}
