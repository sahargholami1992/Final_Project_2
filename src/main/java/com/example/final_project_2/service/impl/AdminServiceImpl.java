package com.example.final_project_2.service.impl;



import com.example.final_project_2.entity.Admin;
import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.Service;
import com.example.final_project_2.entity.SubService;
import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.repository.AdminRepository;
import com.example.final_project_2.service.AdminService;
import com.example.final_project_2.service.ExpertService;
import com.example.final_project_2.service.ServiceService;
import com.example.final_project_2.service.SubServiceService;
import com.example.final_project_2.service.user.UserServiceImpl;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional(readOnly = true)
@org.springframework.stereotype.Service
public class AdminServiceImpl extends UserServiceImpl<Admin, AdminRepository>
                              implements AdminService {
    protected final SubServiceService subServiceService;
    protected final ServiceService serviceService;
    protected final ExpertService expertService;
    public AdminServiceImpl(AdminRepository repository,SubServiceService subServiceService,ServiceService serviceService,ExpertService expertService) {
        super(repository);
        this.subServiceService  =subServiceService;
        this.serviceService=serviceService;
        this.expertService=expertService;
    }




    @Override
    public void saveService(String serviceName) {
        if (!serviceService.existByServiceName(serviceName.toLowerCase())){
            Service service = new Service();
            service.setServiceName(serviceName.toLowerCase());
            serviceService.saveOrUpdate(service);
        }else throw new IllegalArgumentException(" this service existed ");
    }

    @Override
    public void saveSubService(String serviceName, SubService subService) {
        if (serviceService.existByServiceName(serviceName) && !subServiceService.existByName(subService.getSubServiceName())){
            Service service = serviceService.findByServiceName(serviceName);
            subService.setService(service);
            subServiceService.saveOrUpdate(subService);
        }else throw new  IllegalArgumentException(" this service not exist or duplicate subService name ");
}

    @Override
    public void deleteExpertFromSubService(SubService subService, Expert expert) {
        if (subService != null && expert != null && expert.getExpertStatus().equals(ExpertStatus.ACCEPTED) && subService.getExperts().contains(expert) ) {
            subServiceService.deleteByEXPERT(subService, expert);
        }else throw new NullPointerException(" Expert or SubService not found in the database or ExpertStatus is not equals ACCEPTED  ");

    }

    @Override
    public void saveExpertForSubService(SubService subService, Expert expert) {
        if (subService != null && expert != null && expert.getExpertStatus().equals(ExpertStatus.ACCEPTED) ) {
            subServiceService.saveExpert(subService, expert);
        }else throw new NullPointerException(" Expert or SubService not found in the database or ExpertStatus is not equals ACCEPTED  ");

    }

    @Override
    public void registerService(Service service) {
        serviceService.saveOrUpdate(service);
    }

    @Override
    public Collection<SubService> ShowAllSubService() {
        return subServiceService.loadAll();

    }

    @Override
    public Collection<Service> showAllService() {
        return serviceService.loadAll();
    }

    @Override
    public Collection<Expert> showAllExpert() {
        return expertService.loadAll();
    }

    @Override
    public void changeExpertStatus(Expert expert) {
        expertService.changeExpertStatus(expert);
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        return serviceService.existByServiceName(serviceName);
    }

    @Override
    public void editSubService(String subServiceName, double price, String description) {
        subServiceService.editSubService(subServiceName,price,description);
    }
}
