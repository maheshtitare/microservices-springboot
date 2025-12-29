package com.alibou.ecommerce.customer;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Customer REST Controller
 * Base Path: /api/v1/customers
 * NOTE: This service is INTERNAL.
 * Access should happen ONLY via API Gateway.
 */

@RestController
@RequestMapping(
        value = "/api/v1/customers",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    // ================= CREATE CUSTOMER =================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        Customer customer = service.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    // ================= GET ALL CUSTOMERS =================
    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // ================= GET CUSTOMER BY ID =================
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findById(
            @PathVariable String customerId
    ) {
        return ResponseEntity.ok(service.findById(customerId));
    }

    // ================= DELETE CUSTOMER =================
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(
            @PathVariable String customerId
    ) {
        service.delete(customerId);
        return ResponseEntity.noContent().build();
    }
}
