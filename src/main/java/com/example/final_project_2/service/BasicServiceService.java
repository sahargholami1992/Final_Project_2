package com.example.final_project_2.service;


import com.example.final_project_2.entity.BasicService;

import java.util.Collection;

public interface BasicServiceService {
    boolean existByServiceName(String serviceName);

    BasicService findByServiceName(String serviceName);

    Collection<BasicService> loadAll();

    void saveOrUpdate(BasicService basicService);
}
