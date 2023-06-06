package com.c13.c13pizzaapi.services;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.models.Orders;
import com.c13.c13pizzaapi.repos.CustomerRepo;
import com.c13.c13pizzaapi.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    public void addOrder(Long customerId, Orders order){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        order.setCustomer(customer);
        ordersRepo.save(order);
    }
}
