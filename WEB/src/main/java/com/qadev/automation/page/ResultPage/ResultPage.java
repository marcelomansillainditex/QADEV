package com.qadev.automation.page.ResultPage;

import com.qadev.automation.page.BasePage;
import com.qadev.automation.util.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {

    private ResultPageLocators locator;
    public ResultPage() {

        locator = new ResultPageLocators();
    }

    public ResultPage clickOnWikipediaResult(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.wikipediaResult())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator.firstHeadingBy()));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator.bodyContentBy()));
        return this;
    }

    public void displayHistorySection(){
        Logger.printInfo("Go to History section");

        wait.until(ExpectedConditions.presenceOfElementLocated(locator.refSectionBy())).click();
    }

    public boolean checkExpectedYearOfFirstAutomaticProcess( String expectedText){
        Logger.printInfo("Validate if:" + expectedText + "is showed on Wikipedia result. History section");
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator.expectedTextP(expectedText)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
