package com.example.final_project_2.service.impl;



import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.repository.SubServiceRepository;
import com.example.final_project_2.service.SubServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@RequiredArgsConstructor
@Transactional(readOnly = true)
@org.springframework.stereotype.Service
public class SubServiceServiceImpl implements SubServiceService {
    protected final SubServiceRepository repository;
    @Override
    public void deleteByEXPERT(SubService subService, Expert expert) {
        subService.getExperts().remove(expert);
        repository.save(subService);
    }

    @Override
    public void saveExpert(SubService subService, Expert expert) {
        Set<Expert> experts = new HashSet<>();
        experts.add(expert);
        subService.setExperts(experts);
        repository.save(subService);
    }

    @Override
    public void editSubService(String subServiceName, double price, String description) {
        repository.updateSubService(subServiceName,price,description);
    }

    @Override
    public Collection<SubService> findByService(Service service) {
        return repository.findByService(service);
    }

    @Override
    public boolean existByName(String subServiceName) {
        return repository.existsBySubServiceName(subServiceName);
    }

    @Override
    public void saveOrUpdate(SubService subService) {
        repository.save(subService);
    }

    @Override
    public Collection<SubService> loadAll() {
        return repository.findAll();
    }
}
