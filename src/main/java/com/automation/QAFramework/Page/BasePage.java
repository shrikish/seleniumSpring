package com.automation.QAFramework.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.awt.print.PageFormat;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    public void init(){
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();

}
