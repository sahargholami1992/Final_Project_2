package com.example.final_project_2.service.impl;

import com.example.final_project_2.entity.*;
import com.example.final_project_2.entity.enumaration.StatusOrder;
import com.example.final_project_2.repository.CustomerRepository;
import com.example.final_project_2.service.BasicServiceService;
import com.example.final_project_2.service.OrderService;
import com.example.final_project_2.service.SubServiceService;
import com.example.final_project_2.service.dto.CustomerRegisterDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubServiceService subServiceService;

    @Autowired
    private BasicServiceService basicServiceService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    void registerCustomer_ShouldSaveCustomer() {
        // Arrange
        CustomerRegisterDto customerRegisterDto = new CustomerRegisterDto("John","Doe","john.doe@example.com","John1234");


        // Act
        customerService.registerCustomer(customerRegisterDto);

        // Assert

        assertTrue(customerService.existByEmail("john.doe@example.com"));
    }

//    @Test
//    void showAllService_ShouldReturnAllServices() {
//        // Arrange
//
//
//        // Act
//        Collection<BasicService> result = customerService.showAllService();
//
//        // Assert
//        assertNotNull(result);
//
//    }

//    @Test
//    void showAllSubServiceByService_ShouldReturnSubServices() {
//        // Arrange
//        BasicService basicService = new BasicService();
//
//
//        // Act
//        Collection<SubService> result = customerService.showAllSubServiceByService(basicService);
//
//        // Assert
//        assertNotNull(result);
//
//    }

    @Test
    void changeOrderStatusToStarted_WhenSuggestedTimeIsAfterNow_ShouldChangeOrderStatus() {
        // Arrange
        Order order = new Order();
        Offer offer = new Offer();
        offer.setSuggestedTimeToStartWork(LocalDate.now().plusDays(1));

        // Act
        customerService.changeOrderStatusToStarted(order, offer);

        // Assert
        assertEquals(StatusOrder.STARTED,order.getStatusOrder());
    }

    @Test
    void changeOrderStatusToStarted_WhenSuggestedTimeIsBeforeNow_ShouldNotChangeOrderStatus() {
        // Arrange
        Order order = new Order();
        Offer offer = new Offer();
        offer.setSuggestedTimeToStartWork(LocalDate.now().minusDays(1));

        // Act
        customerService.changeOrderStatusToStarted(order, offer);

        // Assert
        assertNotEquals(StatusOrder.STARTED,order.getStatusOrder());
    }

//    @Test
//    void changeOrderStatusToDone_ShouldChangeOrderStatus() {
//        // Arrange
//        Order order = new Order();
//
//        // Act
//        customerService.changeOrderStatusToDone(order);
//
//        // Assert
//    }
}
