// Question: Order service for CRUD operations with Customer integration
package com.alibou.ecommerce.order;

import com.alibou.ecommerce.customer.CustomerClient;
import com.alibou.ecommerce.customer.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    // Constructor Injection
    public OrderService(OrderRepository orderRepository,
                        CustomerClient customerClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
    }

    // ===================== CRUD OPERATIONS =====================

    // Create Order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order by ID
    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));
    }

    // Delete Order
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    // ===================== FEIGN (ORDER → CUSTOMER) =====================

    // Get Customer details from CUSTOMER-SERVICE
    public CustomerResponse getCustomerDetails(String customerId) {
        return customerClient.getCustomerById(customerId);
    }
}
