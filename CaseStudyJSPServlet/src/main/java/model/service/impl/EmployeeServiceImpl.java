package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository EmployeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> selectAllEmployee() {
        return EmployeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return EmployeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee Employee) throws SQLException {
        return EmployeeRepository.updateEmployee(Employee);
    }

    @Override
    public List<Employee> selectByName(String name) throws SQLException {
        return EmployeeRepository.selectByName(name);
    }


    @Override
    public Employee getEmployeeById(int id) {
        return EmployeeRepository.getEmployeeById(id);
    }

    @Override
    public void insertEmployeeStore(Employee Employee) throws SQLException {
        EmployeeRepository.insertEmployeeStore(Employee);
    }
}
