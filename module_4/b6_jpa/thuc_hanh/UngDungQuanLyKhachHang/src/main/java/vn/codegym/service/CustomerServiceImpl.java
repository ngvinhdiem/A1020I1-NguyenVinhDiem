package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public List<Customer> searchByFirstname(String kq) {
        return customerRepository.searchByFirstname(kq);
    }
}