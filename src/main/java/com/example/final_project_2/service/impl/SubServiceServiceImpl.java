package com.example.final_project_2.service.impl;



import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.BasicService;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.repository.SubServiceRepository;
import com.example.final_project_2.service.SubServiceService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SubServiceServiceImpl implements SubServiceService {
    protected final SubServiceRepository repository;
    @Transactional
    @Override
    public void deleteByEXPERT(SubService subService, Expert expert) {
        subService.getExperts().remove(expert);
        repository.save(subService);
    }
    @Transactional
    @Override
    public void saveExpert(SubService subService, Expert expert) {
        Set<Expert> experts = new HashSet<>();
        experts.add(expert);
        subService.setExperts(experts);
        repository.save(subService);
    }
    @Transactional
    @Override
    public SubService editSubService(String subServiceName, double price, String description) {
        if (repository.existsBySubServiceName(subServiceName)) {
            SubService subService = repository.findBySubServiceName(subServiceName).orElseThrow
                    (() -> new NoResultException("userName or password is wrong"));
            subService.setBasePrice(price);
            subService.setDescription(description);
            repository.save(subService);
            return subService;
        }else throw new IllegalArgumentException("this subService name is not exist");
    }

    @Override
    public Collection<SubService> findByService(BasicService basicService) {
        return repository.findByBasicService(basicService);
    }

    @Override
    public boolean existByName(String subServiceName) {
        return repository.existsBySubServiceName(subServiceName);
    }
    @Transactional
    @Override
    public void saveOrUpdate(SubService subService) {
        repository.save(subService);
    }

    @Override
    public Collection<SubService> loadAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
