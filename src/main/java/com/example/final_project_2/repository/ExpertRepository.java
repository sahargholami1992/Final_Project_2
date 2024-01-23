package com.example.final_project_2.repository;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.repository.user.UserRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpertRepository extends UserRepository<Expert> {
    @Query(value = "update Expert e set e.expertStatus = :expertStatus , e.permission= :permission where e.email= :email")
    void updateExpert(Expert expert);

}
