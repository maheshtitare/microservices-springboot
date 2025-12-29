package com.alibou.ecommerce.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    // CustomerRequest -> Customer (Entity)
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
    }

    // Customer -> CustomerResponse
    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}
