package com.demoqa.Pages;

import com.demoqa.Utils.Browser_Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//add a constant path here

public class Home_Page_PO {
    public static final String bookStoreUrl = "https://demoqa.com/books";
    WebDriver driver = new ChromeDriver();

    public void setWebDriver() {
        WebDriver driver = Browser_Setup.getDriver(bookStoreUrl);
    }
    public Home_Page_PO(WebDriver webDriver){
        this.driver=driver;
    }

    //Web elements
    @FindBy(
            css = "#searchBox"
    )
    WebElement searchBox;


    //Methods
    public void addTextToSearchBox(){

        searchBox.sendKeys("git pocket guide");
    }

}
