package model.repository.impl;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.CustomerRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name = ?;";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> CustomerList = new ArrayList<>();
        try{
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMER);

            Customer customer = null;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                Date customerBirthday = resultSet.getDate("customer_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(customerBirthday);
                customer.setCustomerBirthday(date);
                int genderBit = resultSet.getInt("customer_gender");
                String customerGender="";
                if (genderBit==1) customerGender="Nam";
                else customerGender="Nu";
                customer.setCustomerGender(customerGender);
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                CustomerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return CustomerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }


    @Override
    public boolean updateCustomer(Customer Customer) throws SQLException {
        boolean rowUpdated = false;
        try {

            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call update_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1, Customer.getCustomerId());
            callableStatement.setInt(2, Customer.getCustomerTypeId());
            callableStatement.setString(3, Customer.getCustomerName());
            callableStatement.setDate(4, Date.valueOf(Customer.getCustomerBirthday()));
            int genderBit;
            if (Customer.getCustomerGender().equals("Nam")) genderBit=1;
            else genderBit=0;
            callableStatement.setInt(5,genderBit);
            callableStatement.setString(6, Customer.getCustomerIdCard());
            callableStatement.setString(7, Customer.getCustomerPhone());
            callableStatement.setString(8, Customer.getCustomerEmail());
            callableStatement.setString(9, Customer.getCustomerAddress());
            callableStatement.executeUpdate();

            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> selectByName(String name) throws SQLException {
        List<Customer> CustomerList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_CUSTOMER_BY_NAME);

            Customer customer = null;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                Date customerBirthday = resultSet.getDate("customer_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(customerBirthday);
                customer.setCustomerBirthday(date);
                int genderBit = resultSet.getInt("customer_gender");
                String customerGender="";
                if (genderBit==1) customerGender="Nam";
                else customerGender="Nu";
                customer.setCustomerGender(customerGender);
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                CustomerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return CustomerList;
    }


    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_customer_by_id(?)");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                Date customerBirthday = resultSet.getDate("customer_birthday");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(customerBirthday);
                customer.setCustomerBirthday(date);
                int genderBit = resultSet.getInt("customer_gender");
                String customerGender="";
                if (genderBit==1) customerGender="Nam";
                else customerGender="Nu";
                customer.setCustomerGender(customerGender);
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void insertCustomerStore(Customer Customer) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_customer(?,?,?,?,?,?,?,?,?)");
        callableStatement.setInt(1, Customer.getCustomerId());
        callableStatement.setInt(2, Customer.getCustomerTypeId());
        callableStatement.setString(3, Customer.getCustomerName());
        callableStatement.setDate(4, Date.valueOf(Customer.getCustomerBirthday()));
        int genderBit;
        if (Customer.getCustomerGender().equals("Nam")) genderBit=1;
        else genderBit=0;
        callableStatement.setInt(5,genderBit);
        callableStatement.setString(6, Customer.getCustomerIdCard());
        callableStatement.setString(7, Customer.getCustomerPhone());
        callableStatement.setString(8, Customer.getCustomerEmail());
        callableStatement.setString(9, Customer.getCustomerAddress());
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