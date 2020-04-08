package com.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Long customerId;
    private String name;
    private String contact;
    private int age;
}
