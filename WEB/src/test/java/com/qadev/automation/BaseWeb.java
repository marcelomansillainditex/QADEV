package com.qadev.automation;

import com.qadev.automation.driver.BrowserFactory;
import com.qadev.automation.driver.DriverManager;
import com.qadev.automation.util.Logger;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static com.qadev.automation.config.ConfigurationManager.configuration;


public abstract class BaseWeb {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser) {
        driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configuration().implicitlyWait())));
        DriverManager.getDriver().get(configuration().url());

    }

    /**
     * Once the tests have been executed, the tear down method is executed
     * This method is used to take a screenshot of the application whenever a test fails
     * The screenshots are stored in a folder inside resources/results
     * @param result
     */
    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getTestClass().getName().substring(6));
        }

        DriverManager.quit();
    }

    public void takeScreenshot(String name){
        Logger.printInfo("Take screenshot. File name:" + name);

        try {
            String testRunDate = name + " - " + DateTime.now().toString("MMddYYYY") + "_at_" + DateTime.now().toString("HHmm");
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(configuration().pathScreenshots(), testRunDate+".png"));
            Logger.printWarning("Screenshot taken");

        } catch (Exception e) {
            Logger.printWarning("Exception while taking screenshot " + e.getCause());
        }
    }

}
