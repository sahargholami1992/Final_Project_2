package com.example.final_project_2.service;



import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;

import java.util.Collection;

public interface SubServiceService{
    void deleteByEXPERT(SubService subService, Expert expert);

    void saveExpert(SubService subService, Expert expert);
    void editSubService(String subServiceName,double price,String description);

    Collection<SubService> findByService(Service service);

    boolean existByName(String subServiceName);

    void saveOrUpdate(SubService subService);

    Collection<SubService> loadAll();

}
