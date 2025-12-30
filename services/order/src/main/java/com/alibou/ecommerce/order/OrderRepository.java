// Question: Order repository for MongoDB
package com.alibou.ecommerce.order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
