package com.automation.QAFramework.Page.Google;

import com.automation.QAFramework.SpringBasedTestNGTest;
import com.automation.QAFramework.utils.Screenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBasedTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private Screenshot screenshot;

    @Test
    public void googleTest(){
        googlePage.goTo();
        Assert.assertTrue(googlePage.isAt(), "Google Page ");

        googlePage.getSearchComponent().search("Mila Kunis");
        Assert.assertTrue(googlePage.getSearchResult().isAt(), "Google Page search result failed");
        Assert.assertTrue(googlePage.getSearchResult().getCount()>0, "Google Page search result count > 0");
        screenshot.takeScreenshot();
    }

    @AfterTest
    public void tearDown(){
        googlePage.tearDown();
    }
}
