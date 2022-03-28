package com.qadev.automation.config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:application.QA.properties"})
public interface Configuration extends Config {

    @Key("headless")
    Boolean headless();

    @Key("url.google.search")
    String url();

    @Key("timeout")
    String timeout();

    @Key("pollingEvery")
    String pollingEvery();

    @Key("implicitlyWait")
    String implicitlyWait();

    @Key("path.screenshots")
    String pathScreenshots();
}
