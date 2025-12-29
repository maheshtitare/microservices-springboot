package com.alibou.ecommerce.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    // CREATE
    public Customer createCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        return repository.save(customer);
    }

    // GET ALL
    public List<Customer> findAll() {
        return repository.findAll();
    }

    // GET BY ID
    public Customer findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }
}
