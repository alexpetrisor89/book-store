package com.demoqa.TestCases;

        import com.demoqa.Pages.HomePagePo;
        import com.demoqa.Pages.LoginPo;
        import com.demoqa.Pages.SignUpPo;
        import org.openqa.selenium.WebDriver;
        import com.demoqa.Utils.BrowserSetup;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class BookStoreLoginTc extends TCBaseTest {

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
        //driver=browserst.getDriver();
        //homeObj   = new HomePagePo(driver);
        super.setupHomePage();
        homeObj.clickLogin();
        loginObj = new LoginPo(driver);
    }

    @Test
    public void loginWithIncorrectCredentials (){
        loginObj.enterUsername("user");
        loginObj.enterPassword("password");
        loginObj.clickLoginAfterCredentials();
        loginObj.checkCorrectUrl("login");
    }

    //tema - sa validez fiecare pagina
    // template sa fie in basepage
    // clasele copil sa aiba doar parametrii specifici claselor
    //de pe mail ed verificat ce se poate face ca tema

    // create an after ethod for driver.close()

}
