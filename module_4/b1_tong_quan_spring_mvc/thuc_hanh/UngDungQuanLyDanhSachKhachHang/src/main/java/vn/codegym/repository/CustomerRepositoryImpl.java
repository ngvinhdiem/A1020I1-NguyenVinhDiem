package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
        private static List<Customer> customerList;

static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(0, "A", "A@gmail.com", "HN"));
        customerList.add(new Customer(1, "B", "B@gmail.com", "DN"));
        customerList.add(new Customer(2, "C", "C@gmail.com", "HCM"));
        }

@Override
public List<Customer> findAll() {
        return customerList;
        }

@Override
public Customer findById(int id) {
        return customerList.get(id);
        }
}
