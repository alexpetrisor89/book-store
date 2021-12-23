package com.demoqa.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BrowserSetup {


    public static final String pathToWebDriver = "C:\\Users\\alex\\NewAutomationProject\\SampleProject\\chromedriver\\chromedriver.exe";

    public static WebDriver getDriver()  {
        System.setProperty("webdriver.chrome.driver",pathToWebDriver);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}
