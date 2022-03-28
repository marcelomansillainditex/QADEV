package com.qadev.automation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static com.qadev.automation.config.ConfigurationManager.configuration;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("lang=en-GB");
            chromeOptions.setHeadless(configuration().headless());

            return chromeOptions;
        }
    }, FIREFOX {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("intl.accept_languages", "en-GB");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(configuration().headless());
            firefoxOptions.setProfile(firefoxProfile);

            return firefoxOptions;
        }
    }, EDGE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setHeadless(configuration().headless());

            return edgeOptions;
        }
    }, SAFARI {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();

            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);

            return safariOptions;
        }
    };

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}
