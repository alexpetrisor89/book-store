package com.demoqa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile_PO {

    @FindBy(
            xpath = "//button[contains(text(),'Log out')]"
    )
    WebElement logoutButtom;

    @FindBy(
            xpath = "//button[contains(text(),'Delete Account')]"
    )
    WebElement deleteAccountButton;

    @FindBy(
            xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/button[1]"
    )
    WebElement deleteBooksButton;
    @FindBy(
            css = "#gotoStore"
    )
    WebElement goToStoreButton;
    @FindBy(
            css = "div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.profile-wrapper div.ReactTable.-striped.-highlight:nth-child(2) div.pagination-bottom div.-pagination div.-previous > button.-btn"
    )
    WebElement previousButton;

    @FindBy(
            css = "div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.profile-wrapper div.ReactTable.-striped.-highlight:nth-child(2) div.pagination-bottom div.-pagination div.-next > button.-btn"
    )
    WebElement nextButton;

}
