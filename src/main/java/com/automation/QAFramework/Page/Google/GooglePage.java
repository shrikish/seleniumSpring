package com.automation.QAFramework.Page.Google;

import com.automation.QAFramework.Page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class GooglePage extends BasePage {

    @Value("${app.url}")
    private String appURL;

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    public void goTo(){
        driver.get(appURL);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return true;
    }

    public void tearDown(){
        driver.quit();
    }
}
