package com.automation.QAFramework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class Screenshot {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}/img.png")
    private Path path;

    @PostConstruct
    private void init(){
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void takeScreenshot(){
        try {
            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileCopyUtils.copy(sourceFile, path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
