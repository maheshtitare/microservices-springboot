// Question: Create CRUD APIs for Customer
package com.yourpackage.customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.yourpackage.customer.model.Customer;
import com.yourpackage.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    // READ ALL
    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        repository.deleteById(id);
    }
}
