package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    void update(Customer customer);

    List<Customer> searchByFirstname(String kq);
}