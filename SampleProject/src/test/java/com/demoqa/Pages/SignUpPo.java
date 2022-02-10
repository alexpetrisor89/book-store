package com.demoqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPo extends BasePagePo {
    public static final String bookStoreUrl = "register";

    WebDriver driver;
    public SignUpPo(WebDriver driver) {
        super(driver);
        this.setupUrl(bookStoreUrl);
        driver.get(this.getUrl());
        PageFactory.initElements(driver, this);
    }

    @FindBy(
            css = "#firstname"
    )
    WebElement firstNameForSignUp;
    @FindBy(
            css = "#lastname"
    )
    WebElement lastNameForSignUp;
    @FindBy(
            css = "#userName"
    )
    WebElement userNameForSignUp;
    @FindBy(
            css = "#password"
    )
    WebElement passwordForSignUp;
    @FindBy(
            css = "#register"
    )
    WebElement registerButtonForSignUp;

    @FindBy(
            css = "#gotologin"
    )
    WebElement loginButtonForSignUp;
    @FindBy(
            css = "#g-recaptcha"
    )
    WebElement reCaptha;


    public void enterFirstname(String firsName) {
        firstNameForSignUp.sendKeys(firsName);
    }
    public void enterLastName(String lastName) {
        lastNameForSignUp.sendKeys(lastName);
    }
    public void enterUserName(String userName) {
        userNameForSignUp.sendKeys(userName);
    }
    public void enterPassword(String password) {
        passwordForSignUp.sendKeys(password);
    }
    public void clickOnReCapthaButton(){
        reCaptha.click();
    }
    public void clickOnRegisterButton() {
        registerButtonForSignUp.click();
    }
}
