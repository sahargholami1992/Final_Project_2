package com.example.final_project_2.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import com.example.final_project_2.entity.BasicService;
import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.repository.SubServiceRepository;
import com.example.final_project_2.service.AdminService;
import com.example.final_project_2.service.ExpertService;
import com.example.final_project_2.service.dto.ExpertRegisterDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootTest
class SubServiceServiceImplTest {

    @Autowired
    private SubServiceRepository repository;
    @Autowired
    private SubServiceServiceImpl subServiceService;
    @Autowired
    private ExpertService expertService;
    @Autowired
    private AdminService adminService;
    SubService subService;

//    @BeforeEach
//    void setUp() {
//        subService = new SubService();
//        subService.setBasePrice(100);
//        subService.setDescription("Description");
//        subService.setSubServiceName("service name");
//        subServiceService.saveOrUpdate(subService);
//    }
//    }

    @Test
    @Order(5)
    void deleteByEXPERT_ShouldRemoveExpertFromSubService() {
        // Arrange
        SubService subService = new SubService();
        subService.setBasePrice(100);
        subService.setSubServiceName("service nameFirst");
        subServiceService.saveOrUpdate(subService);
        ExpertRegisterDto expertRegisterDto = new ExpertRegisterDto("sgdsg", "jsa", "expertt@emali.com", "Expert12", "3.jpg".getBytes());
        Expert expert = expertService.registerExpert(expertRegisterDto);
        adminService.changeExpertStatus(expert);
        adminService.saveExpertForSubService(subService, expert);


        // Act
        subServiceService.deleteByEXPERT(subService, expert);

        // Assert
        assertTrue(subService.getExperts().isEmpty());
    }

    @Test
    @Order(2)
    void saveExpert_ShouldAddExpertToSubService() {
        // Arrange
        SubService subService = new SubService();
        subService.setBasePrice(100);
        subService.setSubServiceName("service nameSecond");
        subServiceService.saveOrUpdate(subService);
        ExpertRegisterDto expertRegisterDto = new ExpertRegisterDto("sgdsg", "jsa", "expert@emali.com", "Expert12", "3.jpg".getBytes());
        Expert expert = expertService.registerExpert(expertRegisterDto);
        adminService.changeExpertStatus(expert);
        // Act
        subServiceService.saveExpert(subService, expert);
        // Assert
        assertTrue(subService.getExperts().contains(expert));
    }

    @Test
    @Order(3)
    void editSubService_ShouldSaveSubServiceWithNewValues() {
        // Arrange
        SubService subService = new SubService();
        subService.setBasePrice(100);
        subService.setDescription("fdgfdg");
        subService.setSubServiceName("service name");
        subServiceService.saveOrUpdate(subService);
        String subServiceName = "service name";
        double price = 50.0;
        String description = "New Description";
        // Act
        SubService editSubService = subServiceService.editSubService(subServiceName, price, description);
        // Assert
        assertEquals(50, editSubService.getBasePrice());
        assertEquals("New Description", editSubService.getDescription());
    }

//    @Test
//    void findByService_ShouldReturnSubServicesForGivenService() {
//        // Arrange
//        BasicService basicService = new BasicService();
//
//        // Act
//        Collection<SubService> result = subServiceService.findByService(basicService);
//
//        // Assert
//        assertFalse(result.isEmpty());
//
//    }

    @Test
    @Order(4)
    void existByName_ShouldReturnTrueIfSubServiceExists() {
        // Arrange
        String subServiceName = "service nameThird";
        // Act
        boolean result = subServiceService.existByName(subServiceName);
        // Assert
        assertFalse(result);
    }

    @Test
    @Order(1)
    void existByName_ShouldReturnFalseIfSubServiceDoesNotExist() {
        // Arrange
        String subServiceName = "NonExistingSubService";
        // Act
        boolean result = subServiceService.existByName(subServiceName);
        // Assert
        assertFalse(result);
    }

//    @Test
//    void saveOrUpdate_ShouldSaveSubService() {
//        // Arrange
//        SubService subService = new SubService();
//
//        // Act
//        subServiceService.saveOrUpdate(subService);
//
//        // Assert
//
//    }

//    @Test
//    void loadAll_ShouldReturnAllSubServices() {
//        // Arrange
//
//
//        // Act
//        Collection<SubService> result = subServiceService.loadAll();
//
//        // Assert
//        assertFalse(result.isEmpty());
//
//    }
}

