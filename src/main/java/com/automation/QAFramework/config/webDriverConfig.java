package com.automation.QAFramework.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class webDriverConfig {

    @Value("${driver.timeout:30}")
    private int timeout;

    @Bean
    public WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait getWait(WebDriver driver){
        return new WebDriverWait(driver, timeout);
    }

    @Bean
    @Primary
    public WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
