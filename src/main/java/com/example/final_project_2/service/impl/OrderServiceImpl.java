package com.example.final_project_2.service.impl;


import com.example.final_project_2.entity.Customer;
import com.example.final_project_2.entity.Order;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.repository.OrderRepository;
import com.example.final_project_2.service.OrderService;
import com.example.final_project_2.service.dto.OrderDto;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    protected final OrderRepository repository;

    @Override
    public void registerOrder(OrderDto dto, Customer customer, SubService subService) {
        if (dto.getRecommendedPrice() > subService.getBasePrice() && dto.getDateDoOrder().isAfter(LocalDate.now())) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setSubService(subService);
            order.setAddress(dto.getAddress());
            order.setRecommendedPrice(dto.getRecommendedPrice());
            order.setDescription(dto.getDescription());
            order.setDateDoOrder(dto.getDateDoOrder());
            order.setStatusOrder(dto.getStatusOrder());
            repository.save(order);
        }else throw new NoResultException(" time or price in not valid");

    }
}
