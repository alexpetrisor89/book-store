package bookstoreonline.Book_Store_TC;

        import bookstoreonline.Book_Store_PO.HomePage;
        import bookstoreonline.Book_Store_Utils.Browser_Setup;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.annotations.Test;

public class Book_Store {

    String url="https://demoqa.com/books";
    @Test
    public void searchFor(){

        WebDriver driver = Browser_Setup.getDriver(url);

        HomePage obj = PageFactory.initElements(driver, HomePage.class);
        obj.AddTextToSearchBox("git pocket guide");
        obj.ClickOnSearchButton();


    }

}
