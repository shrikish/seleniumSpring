package com.automation.QAFramework;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Autowired
    private Faker faker;

    public String getAddress() {
        return faker.address().fullAddress();
    }
}
