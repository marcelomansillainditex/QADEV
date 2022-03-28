package com.qadev.automation.page.SearchPage;

import com.qadev.automation.page.BasePage;
import com.qadev.automation.page.ResultPage.ResultPage;
import com.qadev.automation.util.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private SearchPageLocators locator;

    public SearchPage() {
        super();
        locator = new SearchPageLocators();
    }

    /**
     * This method fill the information on search input
     * @param searchWord
     */
    public void fillSearchInput(String searchWord) {
        Logger.printInfo("Fill search input: " + searchWord);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator.searchInputBy()));
        element.sendKeys(searchWord);
    }

    public ResultPage clickOnSearchButton() {
        Logger.printInfo("Go to result page ");

        locator.searchButton().sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator.resultsSearchPage()));
        return new ResultPage();
    }


}
