package bookstoreonline.Book_Store_TC;

        import bookstoreonline.Book_Store_PO.Home_Page_PO;
        import bookstoreonline.Book_Store_Utils.Browser_Setup;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.annotations.Test;

public class Book_Store_TC {

    WebDriver driver;
    Home_Page_PO obj = PageFactory.initElements(driver, Home_Page_PO.class);

    @Test
    public void searchFor(){
        obj.setWebDriver();
        obj.addTextToSearchBox("git pocket guide");
        obj.ClickOnSearchButton();
    }

}
