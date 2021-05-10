package com.demoqa.TestCases;

        import com.demoqa.Pages.Home_Page_PO;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.annotations.Test;

public class Book_Store_TC {

    WebDriver driver=new ChromeDriver();
    Home_Page_PO obj = PageFactory.initElements(driver, Home_Page_PO.class);

    @Test
    public void searchFor(){
        driver.get("https://demoqa.com/books");
        driver.findElement(By.cssSelector("#searchBox")).sendKeys("java");
    }

}
