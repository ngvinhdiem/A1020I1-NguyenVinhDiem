package model.service;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository CustomerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> selectAllCustomer() {
        return CustomerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return CustomerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer Customer) throws SQLException {
        return CustomerRepository.updateCustomer(Customer);
    }

    @Override
    public List<Customer> selectByName(String name) throws SQLException {
        return CustomerRepository.selectByName(name);
    }


    @Override
    public Customer getCustomerById(int id) {
        return CustomerRepository.getCustomerById(id);
    }

    @Override
    public void insertCustomerStore(Customer Customer) throws SQLException {
        CustomerRepository.insertCustomerStore(Customer);
    }

}