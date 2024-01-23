package com.example.final_project_2.service;


import com.example.final_project_2.entity.Service;

import java.util.Collection;

public interface ServiceService {
    boolean existByServiceName(String serviceName);

    Service findByServiceName(String serviceName);

    Collection<Service> loadAll();

    void saveOrUpdate(Service service);
}
