package com.demoqa.TestCases;

import com.demoqa.Pages.HomePagePo;
import com.demoqa.Utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TCBaseTest {


    WebDriver driver;
    HomePagePo homeObj;
    BrowserSetup browserst;
    WebElement element;

    public TCBaseTest(){
    }

    @BeforeMethod
    public void setupHomePage(){
        driver=BrowserSetup.getDriver();
        homeObj = new HomePagePo(driver);

    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        this.driver.close();
    }
}
