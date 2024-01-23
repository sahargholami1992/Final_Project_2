package com.example.final_project_2.service;



import com.example.final_project_2.entity.Customer;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.service.dto.CustomerRegisterDto;
import com.example.final_project_2.service.user.UserService;

import java.util.Collection;

public interface CustomerService extends UserService<Customer> {
    void registerCustomer(CustomerRegisterDto dto);
    Collection<Service> showAllService();
    Collection<SubService> showAllSubServiceByService(Service service);
}
