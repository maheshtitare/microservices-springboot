// Question: Create Order entity for MongoDB
package com.alibou.ecommerce.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String customerId;
    private String product;
    private Double amount;
    private String status;
}
