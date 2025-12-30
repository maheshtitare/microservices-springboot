package com.alibou.ecommerce.customer;

public record CustomerResponse(
        String id,
        String name,
        String email
) {}
