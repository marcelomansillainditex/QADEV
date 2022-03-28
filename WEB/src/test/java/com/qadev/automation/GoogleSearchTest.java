package com.qadev.automation;

import com.qadev.automation.page.ResultPage.ResultPage;
import com.qadev.automation.page.SearchPage.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseWeb {

    @Test(description = "Exercise 2: Web automation")
    @Parameters({"searchWord", "expectedYearOfFirstAutomaticProcess"})
    public void wikipediaSearchTest(String searchWord, String expectedYearOfFirstAutomaticProcess) {

        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchInput(searchWord);
        ResultPage resultPage = searchPage.clickOnSearchButton();
        resultPage.clickOnWikipediaResult();
        takeScreenshot("WikipediaResultForAutomatizacion");
        resultPage.displayHistorySection();
        takeScreenshot("WikipediaHistorySection");

        Assert.assertTrue(resultPage.checkExpectedYearOfFirstAutomaticProcess(expectedYearOfFirstAutomaticProcess), "The expected year is not displayed in Wikipedia result");

    }

}
