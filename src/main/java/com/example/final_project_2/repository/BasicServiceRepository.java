package com.example.final_project_2.repository;

import com.example.final_project_2.entity.BasicService;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BasicServiceRepository extends JpaRepository<BasicService,Integer> {

    boolean existsByServiceName(@Pattern(regexp = "^[a-zA-Z\\s]+$") String serviceName);

    Optional<BasicService> findByServiceName(String serviceName);
}
