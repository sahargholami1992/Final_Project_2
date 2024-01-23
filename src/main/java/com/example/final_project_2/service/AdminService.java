package com.example.final_project_2.service;


import com.example.final_project_2.entity.Admin;
import com.example.final_project_2.entity.Expert;

import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.service.user.UserService;


import java.util.Collection;


public interface AdminService extends UserService<Admin> {
    void saveService(String serviceName);
    void saveSubService(String serviceName,SubService subService);
    void deleteExpertFromSubService(SubService subService, Expert expert);
    void saveExpertForSubService(SubService subService, Expert expert);
    void registerService(Service service);
    Collection<SubService> ShowAllSubService();
    Collection<Service> showAllService();
    Collection<Expert> showAllExpert();
    void changeExpertStatus(Expert expert);
    boolean existByServiceName(String serviceName);
    void editSubService(String subServiceName, double price, String description);
}
