package bookstoreonline.Book_Store_PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
//add a constant path here

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver webDriver){
        this.driver=driver;
    }

    //Web elements
    @FindBy(
            css="#searchBox"
    )
    private WebElement searchBox;
    public WebElement getSearchBox(){
        return this.searchBox;
    }

    @FindBy(
            css="#searchBox"
    )
    private WebElement  searchButtonClick;
    private WebElement getSearchButton(){
        return this.searchButtonClick;
    }

    //Methods
    public void addTextToSearchBox(String args){
        searchBox.sendKeys(args);

    }

    public void ClickOnSearchButton(){
        searchButtonClick.click();
    }

}
