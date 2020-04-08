package com.customer.controller;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers/customer")
    public Customer addCustomer(@RequestBody Customer customerToAdd) {
        return customerService.addCustomer(customerToAdd);
    }

    @PutMapping("/customers/customer")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customerToUpdate) {
        return customerService.updateCustomer(customerId, customerToUpdate);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
