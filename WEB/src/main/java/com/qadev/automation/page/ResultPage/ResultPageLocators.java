package com.qadev.automation.page.ResultPage;

import org.openqa.selenium.By;

public class ResultPageLocators {

    public By wikipediaResult() { return By.xpath("//a[contains(@href, 'https://es.wikipedia.org')]//ancestor::h3[contains(., 'Automatización - Wikipedia')]"); }
    public By firstHeadingBy() { return By.id("firstHeading"); }
    public By bodyContentBy() { return By.id("bodyContent"); }
    public By refSectionBy() { return By.cssSelector("span[id='Referencias']"); }
    public By expectedTextP(String expectedText) {
        return By.xpath("//p[contains(., '"+expectedText+"')]");
    }

}
