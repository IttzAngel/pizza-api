package com.c13.c13pizzaapi.controllers;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping("/customers")
//    public ResponseEntity<?> getAllCustomers(){
//        return new ResponseEntity<>(customerService.getALlCustomers(), HttpStatus.OK);
//    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllOrGetCustomerByName(@RequestParam(value = "name", required = false) String name){
        Customer customer = customerService.findCustomerByName(name);
        if(name != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(customerService.getALlCustomers(), HttpStatus.OK);
    }
}
