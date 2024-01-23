package com.example.final_project_2.service.impl;



import com.example.final_project_2.entity.Customer;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.repository.CustomerRepository;
import com.example.final_project_2.service.CustomerService;
import com.example.final_project_2.service.ServiceService;
import com.example.final_project_2.service.SubServiceService;
import com.example.final_project_2.service.dto.CustomerRegisterDto;
import com.example.final_project_2.service.user.UserServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository>
                              implements CustomerService {
    protected final SubServiceService subServiceService;
    protected final ServiceService serviceService;
    public CustomerServiceImpl(CustomerRepository repository, SubServiceService subServiceService, ServiceService serviceService) {
        super(repository);
        this.subServiceService  =subServiceService;
        this.serviceService=serviceService;
    }

    @Override
    public void registerCustomer(CustomerRegisterDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setDateRegister(dto.getDateRegister());
        customer.setRoll(dto.getRoll());
        customer.setPermission(dto.getPermission());
        repository.save(customer);
    }

    @Override
    public Collection<Service> showAllService() {
        return serviceService.loadAll();
    }

    @Override
    public Collection<SubService> showAllSubServiceByService(Service service) {
        return subServiceService.findByService(service);
    }
}
