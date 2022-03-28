package com.qadev.automation.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

    public static String getBrowserInfo() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        return cap.getBrowserName();
    }
}
