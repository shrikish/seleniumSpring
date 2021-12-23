package com.automation.QAFramework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private Address address;

    @Autowired
    private Salary salary;

    public void printDetails(){
        System.out.println("Address : " + address.getAddress());
        System.out.println("Salary : " + salary.getAmount());
    }
}
