package com.example.final_project_2.service;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.service.dto.ExpertRegisterDto;
import com.example.final_project_2.service.user.UserService;

public interface ExpertService extends UserService<Expert> {
    void registerExpert(ExpertRegisterDto dto);

    void changeExpertStatus(Expert expert);

}
