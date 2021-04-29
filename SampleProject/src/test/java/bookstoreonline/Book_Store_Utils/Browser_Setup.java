package bookstoreonline.Book_Store_Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Browser_Setup {


    public static final String pathToWebDriver = "C:\\Users\\alex\\NewAutomationProject\\SampleProject\\chromedriver\\chromedriver.exe";

    public static WebDriver getDriver(String url)  {
        System.setProperty("webdriver.chrome.driver",pathToWebDriver);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);
        Reporter.log("Navigated to URL"+url);
        return driver;
    }
}
