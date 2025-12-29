package com.example.CourseWeb.repo;


import com.example.CourseWeb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

//    Order save(Order order);
}
