package com.example.final_project_2.service;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.Order;
import com.example.final_project_2.service.dto.ExpertRegisterDto;
import com.example.final_project_2.service.dto.OfferDto;
import com.example.final_project_2.service.user.UserService;

public interface ExpertService extends UserService<Expert> {
    Expert registerExpert(ExpertRegisterDto dto);

    void changeExpertStatus(Expert expert);
    void sendOffer(Expert expert,Order order, OfferDto dto);
    byte[] readsImage(String imageName);
    boolean saveImageToFile(byte[] imageData, String outputPath);
    Expert saveExpert(Expert expert);

}
