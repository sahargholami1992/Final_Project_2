package com.example.final_project_2.service.impl;

import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.Order;
import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.entity.enumaration.Permission;
import com.example.final_project_2.repository.ExpertRepository;
import com.example.final_project_2.service.AdminService;
import com.example.final_project_2.service.ExpertService;
import com.example.final_project_2.service.OfferService;
import com.example.final_project_2.service.dto.ExpertRegisterDto;
import com.example.final_project_2.service.dto.OfferDto;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExpertServiceImplTest {

    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private OfferService offerService;
    @Autowired
    private ExpertService expertService;
    @Autowired
    private AdminService adminService;
    private ExpertRegisterDto expertRegisterDto;
    private Expert expert;

    @BeforeEach
    void setUp() throws IOException {
        expertRegisterDto = new ExpertRegisterDto("John","Doe","john.doe@example.com","Passwor1", Files.readAllBytes(Paths.get("C:\\Users\\ZAITOON.iR\\IdeaProjects\\Final_Project_2\\src\\main\\resources\\3.jpg")));
        expert = expertService.registerExpert(expertRegisterDto);




    }

    @Test
    void registerExpert_ShouldSaveExpert() {
        // Arrange

        // Act

        // Assert
//
       assertTrue(expertService.existByEmail(expertRegisterDto.getEmail()));
    }

    @Test
    void changeExpertStatus_ShouldSaveExpert() {
        // Arrange


        // Act
        expertService.changeExpertStatus(expert);

        // Assert
    }

//    @Test
//    void sendOffer_ShouldCallOfferService() {
//        // Arrange
//        Expert expert = new Expert();
//        Order order = new Order();
//        OfferDto offerDto = new OfferDto();
//
//        // Act
//        expertService.sendOffer(expert, order, offerDto);
//
//        // Assert
//    }

    @Test
    void logIn_WhenValidCredentials_ShouldReturnExpert() {
        // Arrange
//        expert.setExpertStatus(ExpertStatus.ACCEPTED);
//        expert.setPermission(Permission.ACCEPTED);
//        expertService.saveExpert(expert);
        adminService.changeExpertStatus(expert);
        String email = "john.doe@example.com";
        String password = "Passwor1";



//        expertService.changeExpertStatus(expert);
//        Expert expert = new Expert();
//        expert.setEmail(email);
//        expert.setPassword(password);

        // Act
        expertService.logIn(email, password);

        // Assert
        assertNotNull(expert);
//        assertEquals(expert, expert1);
    }

    @Test
    void logIn_WhenInvalidCredentials_ShouldThrowException() {
        // Arrange
        String email = "john.doe@example.com";
        String password = "password";

        // Act & Assert
        assertThrows(NoResultException.class, () -> expertService.logIn(email, password));
    }

    @Test
    void logIn_WhenInvalidPassword_ShouldThrowException() {
        // Arrange
        String email = "john.doe@example.com";
        String password = "password";
        Expert expert = new Expert();
        expert.setEmail(email);
        expert.setPassword("wrongPassword");

        // Act & Assert
        assertThrows(RuntimeException.class, () -> expertService.logIn(email, password));
    }

    @Test
    void readsImage_WhenImageExists_ShouldReturnImageData() {
        // Arrange
        String imageName = "3.jpg";
        InputStream inputStream = new ByteArrayInputStream(new byte[1024]);

        // Act
        byte[] result = expertService.readsImage(imageName);

        // Assert
        assertNotNull(result);
        assertEquals(5154, result.length);
    }

    @Test
    void readsImage_WhenImageDoesNotExist_ShouldReturnNull() {
        // Arrange
        String imageName = "nonexistent.jpg";

        // Act
        byte[] result = expertService.readsImage(imageName);

        // Assert
        assertNull(result);
    }

    @Test
    void saveImageToFile_WhenSuccessfulSave_ShouldReturnTrue() {
        // Arrange
        byte[] imageData = expert.getProfileImage();
        String outputPath = "output.jpg";

        // Act
        boolean result = expertService.saveImageToFile(imageData, outputPath);

        // Assert
        assertTrue(result);
    }

    @Test
    void saveImageToFile_WhenFailedSave_ShouldReturnFalse() {
        // Arrange
        byte[] imageData = new byte[]{1, 2, 3};
        String outputPath = "nonexistent/folder/output.jpg";

        // Act
        boolean result = expertService.saveImageToFile(imageData, outputPath);

        // Assert
        assertFalse(result);
    }
}
