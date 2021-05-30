package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer Customer) throws SQLException;

    List<Customer> selectByName(String name) throws SQLException;


    Customer getCustomerById (int id);

    void insertCustomerStore(Customer Customer) throws SQLException;



}