package com.example.final_project_2.repository;

import com.example.final_project_2.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    boolean existsByServiceName(String serviceName);

    Optional<Service> findByServiceName(String serviceName);
}
