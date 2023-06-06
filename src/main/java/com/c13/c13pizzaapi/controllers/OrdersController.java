package com.c13.c13pizzaapi.controllers;

import com.c13.c13pizzaapi.models.Orders;
import com.c13.c13pizzaapi.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("customers/{customerId}/orders")
    public ResponseEntity<Void> createOrder(@PathVariable Long customerId, @RequestBody Orders order){
        ordersService.addOrder(customerId, order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("customers/{customerId}/orders")
    public ResponseEntity<List<Orders>> getAllOrdersById(@PathVariable Long customerId){
        return new ResponseEntity<>(ordersService.getAllOrdersByCustomerId(customerId), HttpStatus.OK);
    }

    @PutMapping("customers/{customerId}/orders/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long customerId, @PathVariable Long orderId, @RequestBody Orders order){
        ordersService.updateOrder(customerId, orderId, order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("customers/{customerId}/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long customerId, @PathVariable Long orderId){
        ordersService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
