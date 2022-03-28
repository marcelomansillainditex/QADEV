package com.qadev.automation.page.SearchPage;

import com.qadev.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageLocators {

    public By searchInputBy() { return By.cssSelector("input[class='gLFyf gsfi']"); }

    public WebElement searchButton() { return DriverManager.getDriver().findElement(searchInputBy()); }

    public By resultsSearchPage() {return By.id("search");}
}
