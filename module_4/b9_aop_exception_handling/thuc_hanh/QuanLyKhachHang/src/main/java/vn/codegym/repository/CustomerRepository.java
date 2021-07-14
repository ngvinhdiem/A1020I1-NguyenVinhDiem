package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    @Query("select cus from Customer cus where cus.firstName =:input")
    List<Customer> searchByFirstName(@Param("input") String kq);
}