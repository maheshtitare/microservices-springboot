package com.alibou.ecommerce.customer;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    // READ ALL
    public List<Customer> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Customer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }
}
