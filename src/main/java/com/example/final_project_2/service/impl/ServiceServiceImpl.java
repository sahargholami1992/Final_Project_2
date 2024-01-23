package com.example.final_project_2.service.impl;


import com.example.final_project_2.entity.Service;
import com.example.final_project_2.repository.ServiceRepository;
import com.example.final_project_2.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional(readOnly = true)
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    protected final ServiceRepository repository;
    @Override
    public boolean existByServiceName(String serviceName) {
        return repository.existsByServiceName(serviceName);
    }

    @Override
    public Service findByServiceName(String serviceName) {
        return repository.findByServiceName(serviceName).orElseThrow(() -> new NullPointerException("userName or password is wrong"));
    }

    @Override
    public Collection<Service> loadAll() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdate(Service service) {
        repository.save(service);
    }
}
