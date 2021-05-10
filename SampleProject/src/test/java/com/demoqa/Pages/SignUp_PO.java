package com.demoqa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp_PO {

    @FindBy(
            css = "#firstname"
    )
    WebElement firstNameField;
    @FindBy(
            css = "#lastname"
    )
    WebElement lastNameField;
    @FindBy(
            css = "#userName"
    )
    WebElement userNameField;
    @FindBy(
            css = "#userName"
    )
    WebElement passwordField;
    @FindBy(
            css = "#register"
    )
    WebElement registerButton;
    @FindBy(
            css = "#gotologin"
    )
    WebElement goToLoginButton;

    //for reCaptha
    /*@FindBy(
            css = "#userName"
    )
    WebElement passwordField;*/
}
