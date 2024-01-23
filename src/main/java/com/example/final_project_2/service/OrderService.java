package com.example.final_project_2.service;


import com.example.final_project_2.entity.Customer;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.service.dto.OrderDto;

public interface OrderService  {
    void registerOrder(OrderDto dto, Customer customer, SubService subService);
}
