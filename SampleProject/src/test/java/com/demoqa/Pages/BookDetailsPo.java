package com.demoqa.Pages;

import com.demoqa.Utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPo extends BasePagePo {
    BrowserSetup bsst = new BrowserSetup();

    public BookDetailsPo(WebDriver driver) {
        super(driver);
        this.setupUrl(bookStoreUrl);
        driver.get(this.getUrl());
        PageFactory.initElements(driver, this);
    }

    public String getUrlSubstring(){
        String currentUrl = driver.getCurrentUrl();
        String newURL = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
        return newURL;
    }
    public String bookStoreUrl = getUrlSubstring();

    @FindBy(
            css = "#author-wrapper > div.col-md-9.col-sm-12"
    )
    public WebElement author;
    public WebElement getAuthor(){
        return this.author;
    }

    @FindBy(
            css = "#publisher-wrapper > div.col-md-9.col-sm-12"
    )
    public WebElement publisher;
    public WebElement getPublisher(){
        return this.publisher;
    }

    @FindBy(
            css = "#ISBN-wrapper > div.col-md-9.col-sm-12"
    )
    public WebElement isbn;
    public WebElement getIsbn(){
        return this.isbn;
    }

    @FindBy(
            css = "#title-wrapper > div.col-md-9.col-sm-12"
    )
    public WebElement title;
    public WebElement getTitle(){ return this.title; }
}
