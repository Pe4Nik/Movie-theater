package com.customer.repository;

import com.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        initCustomers();
    }

    private static void initCustomers() {
        Customer customer1 = new Customer(1L,"CustomerOne", "89501234567", 17);
        Customer customer2 = new Customer(2L,"CustomerTwo", "89121234567", 21);
        Customer customer3 = new Customer(3L,"CustomerThree", "89511234567", 34);

        customers = Arrays.asList(customer1, customer2, customer3);
    }

    public Customer getCustomer(Long customerId) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findAny()
                .get();
    }

    public Customer addCustomer(Customer customerToAdd) {
        if (!customers.contains(customerToAdd)) {
            customers.add(customerToAdd);
        } else {
            System.out.println("Customer already exist");
        }
        return customerToAdd;
    }

    public Customer updateCustomer(Long customerId, Customer customerToUpdate) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .map(customer -> customer = customerToUpdate)
                .findAny()
                .get();
    }

    public void deleteCustomer(Long customerId) {
        if (customers.contains(customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findAny()
                .get())) {
            customers.remove(getCustomer(customerId));
        }
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
