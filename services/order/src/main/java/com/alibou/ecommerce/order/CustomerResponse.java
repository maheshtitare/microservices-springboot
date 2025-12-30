package com.alibou.ecommerce.order;

public record CustomerResponse(
        Integer id,
        String firstname,
        String lastname,
        String email
) {}
