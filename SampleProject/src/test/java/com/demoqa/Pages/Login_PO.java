package com.demoqa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO {
    @FindBy(
            css = "#userName"
    )
    WebElement userNameForLogin;
    @FindBy(
            css = "#password"
    )
    WebElement passwordForLogin;
    @FindBy(
            css = "//button[@id='login']"
    )
    WebElement loginButton;
    @FindBy(
            css = "//button[@id='newUser']"
    )
    WebElement newUser;
}
