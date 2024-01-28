package com.example.final_project_2.repository;
import com.example.final_project_2.entity.BasicService;
import com.example.final_project_2.entity.SubService;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface SubServiceRepository extends JpaRepository<SubService,Integer> {

    Collection<SubService> findByBasicService(BasicService basicService);

    boolean existsBySubServiceName(String subServiceName);
    Optional<SubService> findBySubServiceName(String subServiceName);

}
