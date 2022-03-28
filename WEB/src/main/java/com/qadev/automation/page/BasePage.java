package com.qadev.automation.page;

import com.qadev.automation.driver.DriverManager;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.*;

import java.time.Duration;

import static com.qadev.automation.config.ConfigurationManager.configuration;


public abstract class BasePage {
    protected Wait<WebDriver> wait;

    public BasePage() {
        wait = new FluentWait<WebDriver>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(configuration().timeout())))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(configuration().pollingEvery())))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(NoSuchFrameException.class);

    }

}
