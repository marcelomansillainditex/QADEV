# Exercise 2

## Automation framework

* [Java 14](https://openjdk.java.net/projects/jdk/11/)
* [Maven](https://maven.apache.org/docs/3.8.1/release-notes.html)
* [TestNG](https://testng.org/doc/)
* [Selenium WebDriver](https://www.selenium.dev/)
* [AssertJ](https://joel-costigliola.github.io/assertj/)
* [Allure Report](https://docs.qameta.io/allure/)
* [Log4J2](https://logging.apache.org/log4j/2.x/)
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

#### Page Object Model
POM: `src/main/java/com/qadev/automation/page`
+ _namePageLocators_ class
+ _namePage_ class 

#### BrowserFactory class
Java enum class responsible for create a driver with specific configurations

### Test Execution

There are a suite for each browser
* chrome.xml
* edge.xml
* firefox.xml
* safari.xml

The suites are located in _src/test/resources/suites_

#### Maven Execution
There is a property on `pom.xml` file to define which suite run
```xml
    <properties>
        <suite>chrome</suite>
    </properties>
```
* Use `-Dsuite=suite_name` to call the suite

Eg: executing the chrome suite
````bash
mvn test -Dsuite=chrome 
````
Eg: executing the edge suite
````bash
mvn test -Dsuite=edge 
````

### Allure Report

````bash
mvn allure:serve 
````
