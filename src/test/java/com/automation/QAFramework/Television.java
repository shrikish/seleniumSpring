package com.automation.QAFramework;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Television {

    @Autowired
    private Faker faker;

    @Value("${tv.name:Sony}")
    private String name;

    public Television(){
        System.out.println("In TV constructor : "+ name);
    }

    @PostConstruct
    public void init(){
        System.out.println("In init : " + name);
        System.out.println("TV on now");
    }

    public void playMovie(){
        for (int i=0;i<5;i++){
            System.out.println("Playing " + faker.dragonBall().character());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    public void turnOff(){
        System.out.println("TV turned off");
    }
}
