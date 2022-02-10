package com.demoqa.TestCases;

import com.demoqa.Pages.HomePagePo;
import com.demoqa.Pages.LoginPo;
import com.demoqa.Pages.SignUpPo;
import com.demoqa.Utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreSignUpTC extends TCBaseTest {


    WebDriver driver;
    HomePagePo homeObj;
    LoginPo loginObj;
    SignUpPo signUpObj;
    BrowserSetup browserst;

    //nu trebuie sa iitializez tot in before test ca va pusca
    //elemente vizibil in browser la momentul instantierii unui page object
    //de rulat teste cu debug

    //

    @BeforeMethod
    public void setup(){
        driver=browserst.getDriver();
        homeObj   = new HomePagePo(driver);
        homeObj.clickLogin();
        loginObj = new LoginPo(driver);
    }

    @Test
    public void SignupHappyFlow(){
        loginObj.clickSignUp();
        signUpObj = new SignUpPo(driver);
        signUpObj.enterFirstname("firstnameUser");
        signUpObj.enterLastName("lastnameUser");
        signUpObj.enterUserName("user");
        signUpObj.enterPassword("password");
        //use sleep
        signUpObj.clickOnReCapthaButton();
        signUpObj.clickOnRegisterButton();

    }
}
