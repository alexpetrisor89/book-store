package bookstoreonline.Book_Store_PO;

import bookstoreonline.Book_Store_Utils.Browser_Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//add a constant path here

public class Home_Page_PO {
    public static final String bookStoreUrl = "https://demoqa.com/books";

    public void setWebDriver() {
        WebDriver driver = Browser_Setup.getDriver(bookStoreUrl);
    }

    WebDriver driver;
    public Home_Page_PO(WebDriver webDriver){
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
