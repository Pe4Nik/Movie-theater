package com.customer.service.implementation;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.getCustomer(customerId);
    }

    @Override
    public Customer addCustomer(Customer customerToAdd) {
        return customerRepository.addCustomer(customerToAdd);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customerToUpdate) {
        return customerRepository.updateCustomer(customerId, customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
