package com.example.final_project_2.service.impl;

import com.example.final_project_2.entity.BasicService;
import com.example.final_project_2.repository.BasicServiceRepository;


import com.example.final_project_2.service.BasicServiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BasicServiceServiceImplTest {

    @Autowired
    private BasicServiceRepository basicServiceRepository;

    @Autowired
    private BasicServiceService basicServiceService;
    String serviceName;
    @BeforeEach
    void setUp() {
        serviceName = "building decoration";
        BasicService basicService = new BasicService();
        basicService.setServiceName(serviceName);
        basicServiceService.saveOrUpdate(basicService);
    }

    @Test
    void existByServiceName_WhenServiceExists_ShouldReturnTrue() {
        // Arrange
//        String serviceName = "building decoration";
//        BasicService basicService = new BasicService();
//        basicService.setServiceName(serviceName);
//        basicServiceService.saveOrUpdate(basicService);

        // Act
        boolean result = basicServiceService.existByServiceName(serviceName);

        // Assert
        assertTrue(result);
//
    }

    @Test
    void existByServiceName_WhenServiceDoesNotExist_ShouldReturnFalse() {
        // Arrange
        String serviceName = "NonExistentService";


        // Act
        boolean result = basicServiceService.existByServiceName(serviceName);

        // Assert
        assertFalse(result);
//
    }

    @Test
    void findByServiceName_WhenServiceExists_ShouldReturnBasicService() {
        // Arrange
//        String serviceName = "building decoration";
//        BasicService expectedService = new BasicService();
//        expectedService.setServiceName(serviceName);

        // Act
        BasicService result = basicServiceService.findByServiceName(serviceName);

        // Assert
        assertNotNull(result);
//        assertEquals(, result);
    }

    @Test
    void findByServiceName_WhenServiceDoesNotExist_ShouldThrowNullPointerException() {
        // Arrange
        String serviceName = "NonExistentService";

        // Act and Assert
        assertThrows(NullPointerException.class, () -> basicServiceService.findByServiceName(serviceName));
//
    }

//    @Test
//    void loadAll_ShouldReturnAllServices() {
//        // Arrange
////        when(basicServiceRepository.findAll()).thenReturn(mock(Collection.class));
//
//        // Act
//        Collection<BasicService> result = basicServiceService.loadAll();
//
//        // Assert
//        assertNotNull(result);
////        verify(basicServiceRepository, times(1)).findAll();
//    }

//    @Test
//    void saveOrUpdate_ShouldSaveBasicService() {
//        // Arrange
//        BasicService basicService = new BasicService();
//
//        // Act
//        basicServiceService.saveOrUpdate(basicService);
//
//        // Assert
//
//    }
}
