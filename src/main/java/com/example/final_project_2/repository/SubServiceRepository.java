package com.example.final_project_2.repository;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SubServiceRepository extends JpaRepository<SubService,Integer> {

    void updateSubService(String subServiceName, double price, String description);

    Collection<SubService> findByService(Service service);

    boolean existsBySubServiceName(String subServiceName);

}
