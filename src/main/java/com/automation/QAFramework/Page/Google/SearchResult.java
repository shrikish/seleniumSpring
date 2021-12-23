package com.automation.QAFramework.Page.Google;

import com.automation.QAFramework.Page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResult extends BasePage {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public int getCount(){
        System.out.println(links.size());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return links.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((link) -> !links.isEmpty());
    }
}
