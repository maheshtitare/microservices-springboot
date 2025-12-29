// Question: Create MongoRepository for Customer
package com.yourpackage.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.yourpackage.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
