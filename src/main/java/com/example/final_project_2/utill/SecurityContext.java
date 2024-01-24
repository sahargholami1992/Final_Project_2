package com.example.final_project_2.utill;


import lombok.Getter;
import org.example.entity.Admin;
import org.example.entity.Customer;
import org.example.entity.Expert;


public class SecurityContext {

    private SecurityContext() {
    }

    @Getter
    private static Admin currentAdmin;

    @Getter
    private static Customer currentCustomer;

    @Getter
    private static Expert currentExpert;



    public static void fillContext(Admin admin) {
        currentAdmin = admin;
    }
    public static void fillContext(Expert expert) {
        currentExpert = expert;
    }
    public static void fillContext(Customer customer) {
        currentCustomer = customer;
    }




}
