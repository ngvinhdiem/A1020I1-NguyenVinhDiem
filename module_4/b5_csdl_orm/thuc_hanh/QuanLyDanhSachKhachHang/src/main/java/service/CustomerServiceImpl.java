package service;

import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import java.util.*;

public class CustomerServiceImpl implements CustomerService{
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer update(int id, Customer customer) {
        return customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
