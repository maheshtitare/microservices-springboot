package com.alibou.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(

        @NotBlank(message = "Customer firstName is required")
        String firstName,

        @NotBlank(message = "Customer lastName is required")
        String lastName,

        @NotBlank(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        String email
) {
}
