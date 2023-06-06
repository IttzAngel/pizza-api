package com.c13.c13pizzaapi.services;

import com.c13.c13pizzaapi.models.Customer;
import com.c13.c13pizzaapi.models.Orders;
import com.c13.c13pizzaapi.repos.CustomerRepo;
import com.c13.c13pizzaapi.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Orders> getAllOrdersByCustomerId(Long customerId){
        return ordersRepo.findAllOrdersByCustomerId(customerId);
    }

    public void updateOrder(Long customerId, Long ordersId, Orders order){
        Customer customer = customerRepo.findById(customerId).orElse(null);
        Orders o = ordersRepo.findById(ordersId).orElse(null);
        if(o != null){
            o.setCrust(order.getCrust());
            o.setToppings(order.getToppings());
        }
        order.setCustomer(customer);
        ordersRepo.save(order);
    }

    public void getOrderById(){

    }

    public void deleteOrder(Long id){
        ordersRepo.deleteById(id);
    }
}
