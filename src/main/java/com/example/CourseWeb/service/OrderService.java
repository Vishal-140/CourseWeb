package com.example.CourseWeb.service;


import com.example.CourseWeb.model.Order;
import com.example.CourseWeb.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order placeOrder(Order order) {
        return orderRepo.save(order);
    }
}
