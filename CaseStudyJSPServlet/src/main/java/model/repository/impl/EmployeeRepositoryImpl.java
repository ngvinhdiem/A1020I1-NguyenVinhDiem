package model.repository.impl;
import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where employee_name = ?;";

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try{
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EMPLOYEE);

            Employee employee = null;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                Date employeeBirthday = resultSet.getDate("employee_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(employeeBirthday);
                employee.setEmployeeBirthday(date);
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setEmployeePositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }


    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call update_employee(?,?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1, employee.getEmployeeId());
            callableStatement.setString(2, employee.getEmployeeName());
            callableStatement.setDate(3, Date.valueOf(employee.getEmployeeBirthday()));
            callableStatement.setString(4, employee.getEmployeeIdCard());
            callableStatement.setDouble(5, employee.getEmployeeSalary());
            callableStatement.setString(6, employee.getEmployeePhone());
            callableStatement.setString(7, employee.getEmployeeEmail());
            callableStatement.setString(8, employee.getEmployeeAddress());
            callableStatement.setInt(9, employee.getEmployeePositionId());
            callableStatement.setInt(10, employee.getEducationDegreeId());
            callableStatement.setInt(11, employee.getDivisionId());
            callableStatement.executeUpdate();
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> selectByName(String name) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_EMPLOYEE_BY_NAME);

            Employee employee = null;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                Date employeeBirthday = resultSet.getDate("employee_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(employeeBirthday);
                employee.setEmployeeBirthday(date);
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setEmployeePositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_employee_by_id(?)");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                Date employeeBirthday = resultSet.getDate("employee_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(employeeBirthday);
                employee.setEmployeeBirthday(date);
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setEmployeePositionId(resultSet.getInt("position_id"));
                employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                employee.setDivisionId(resultSet.getInt("division_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void insertEmployeeStore(Employee employee) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_employee(?,?,?,?,?,?,?,?,?,?,?)");
        callableStatement.setInt(1, employee.getEmployeeId());
        callableStatement.setString(2, employee.getEmployeeName());
        callableStatement.setDate(3, Date.valueOf(employee.getEmployeeBirthday()));
        callableStatement.setString(4, employee.getEmployeeIdCard());
        callableStatement.setDouble(5, employee.getEmployeeSalary());
        callableStatement.setString(6, employee.getEmployeePhone());
        callableStatement.setString(7, employee.getEmployeeEmail());
        callableStatement.setString(8, employee.getEmployeeAddress());
        callableStatement.setInt(9, employee.getEmployeePositionId());
        callableStatement.setInt(10, employee.getEducationDegreeId());
        callableStatement.setInt(11, employee.getDivisionId());
        callableStatement.executeUpdate();
    }



    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
