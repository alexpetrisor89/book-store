package com.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import javax.swing.text.html.CSS;

//un atribun, site-ul
//metoda ce returneaza url si suprascriu url
//refactor class names(done)

// setup URL
//static final
// no private params on basepage
//

public class BasePagePo {
    public WebDriver driver;
    private String BOOK_STORE_URL = "https://demoqa.com/";

    public BasePagePo(WebDriver driver) {
        this.driver=driver;
    }
    public String getUrl() {
        return BOOK_STORE_URL;
    }

    public String setupUrl(String extraUrl){
        return BOOK_STORE_URL+=extraUrl;
    }
//rerun this on basepage
    public void checkCorrectUrl(String expectedURL){
        String expURL= "https://demoqa.com/" + expectedURL;
        String actualURL=driver.getCurrentUrl();
        if(actualURL.equals(expURL))
            System.out.println("User on the correct page");
        else
            System.out.println("Recheck URL");
    }


}
