package com.customer.service;

import com.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long customerId);
    Customer addCustomer(Customer customerToAdd);
    Customer updateCustomer(Long customerId, Customer customerToUpdate);
    void deleteCustomer(Long customerId);
    List<Customer> getAllCustomers();
}
