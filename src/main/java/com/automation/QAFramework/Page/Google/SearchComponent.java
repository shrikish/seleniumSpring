package com.automation.QAFramework.Page.Google;

import com.automation.QAFramework.Page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchbox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    public void search(String searchText){
        searchbox.sendKeys(searchText);
        searchbox.sendKeys(Keys.TAB);
        searchBtn.stream()
                .filter(btn -> btn.isDisplayed() && btn.isEnabled())
                .findFirst()
                .ifPresent(btn -> btn.click());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> searchbox.isDisplayed());
    }
}
