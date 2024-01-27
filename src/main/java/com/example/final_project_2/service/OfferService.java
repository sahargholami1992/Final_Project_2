package com.example.final_project_2.service;

import com.example.final_project_2.entity.*;
import com.example.final_project_2.service.dto.OfferDto;

import java.util.Collection;
import java.util.List;

public interface OfferService {
    void saveOffer(Expert expert, Order order, OfferDto dto);
    Collection<Offer> getOffersForOrder(Customer customer,String sortBy);
    Collection<Offer> findAllByOrderOfCustomer(Customer customer);

}
