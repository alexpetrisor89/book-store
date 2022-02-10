package com.demoqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPo extends BasePagePo {
    public static final String bookStoreUrl = "login";

    WebDriver driver;
    public LoginPo(WebDriver driver) {
        super(driver);
        this.setupUrl(bookStoreUrl);
        driver.get(this.getUrl());
        PageFactory.initElements(driver, this);
    }


    @FindBy(
            css = "#userName"
    )
    public WebElement userNameForLogin;

    @FindBy(
            css = "#password"
    )
    public WebElement passwordForLogin;

    @FindBy(
            css = "#login"
    )
    public WebElement loginButton;

    @FindBy(
            css = "#newUser"
    )
    WebElement newUser;

    public void enterUsername(String user) {
        userNameForLogin.sendKeys(user);
    }
    public void enterPassword(String password) {
        passwordForLogin.sendKeys(password);
    }
    public void clickLoginAfterCredentials() {
        loginButton.click();
    }
    public void clickSignUp(){
        newUser.click();
    }
}
