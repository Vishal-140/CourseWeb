package com.example.CourseWeb.controller;

import com.example.CourseWeb.model.Order;
import com.example.CourseWeb.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> showAllOrders(){
        return new ResponseEntity<>
                (orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        return new ResponseEntity<>
                (orderService.placeOrder(order), HttpStatus.CREATED);
    }


}