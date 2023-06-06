package com.c13.c13pizzaapi.services;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public Iterable<Customer> getALlCustomers(){
        return customerRepo.findAll();
    }
    public Optional<Customer> findCustomerById(Long id){
        return customerRepo.findById(id);
    }

    public void updateCustomer(Long id, Customer customer){
        customer.setId(id);
        customerRepo.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
    }


}
