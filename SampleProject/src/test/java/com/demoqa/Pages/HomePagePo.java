package com.demoqa.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.Random;


public class HomePagePo extends BasePagePo {

    public HomePagePo(WebDriver driver) {
        super(driver);
        this.setupUrl(BOOK_STORE_URL);
        driver.get(this.getUrl());
        PageFactory.initElements(driver, this);
    }

    public static final String BOOK_STORE_URL = "books";

    @FindBy(
            css = "#searchBox"
    )
    public WebElement searchBox;

    @FindBy(
            css = "#login"
    )
    public WebElement loginBtn;

    @FindAll({
            @FindBy(css = "div.rt-tbody > div:nth-child(1) > div > div:nth-child(2)"),
            @FindBy(css = "div.rt-tr-group .action-buttons")
    })
    public List<WebElement> bookTitleFromHomepage;


    public String getBookTitle(WebElement element) throws NoSuchElementException, NullPointerException {
        String bookTitle = null;
        try {
            bookTitle = element.findElement(By.cssSelector("div.action-buttons")).getText();
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
        } finally {
            return bookTitle;
        }
    }

    public String getBookAuthor(WebElement element) throws NoSuchElementException {
        String bookAuthor = "";
        try {
            bookAuthor = element.findElement(By.cssSelector("div > div:nth-child(3)")).getText();
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
        } finally {
            return bookAuthor;
        }
    }


    public List<WebElement> returnAllBook() {
        List<WebElement> results = driver.findElements(By.cssSelector("div.rt-tr-group"));
        return results;
    }

    public List<WebElement> returnAllTitles(){
        List<WebElement> results = driver.findElements(By.cssSelector("div.rt-tr-group .action-buttons > span > a"));
        return results;
    }


    public String searchForEmptyBookList() {
        String bookTitleGet = bookTitleFromHomepage.get(0).getText();
        return bookTitleGet;
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void selectBookTitle() {
        bookTitleFromHomepage.get(1).click();
    }

    public void addTextToSearchBox(String bookSerachString) {
        searchBox.sendKeys(bookSerachString);
    }

    public void waitForElementToBeVisible(String cssSelSearch) {
        try {
            @Deprecated
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelSearch)));
        } catch (Exception e) {
            System.out.println("To mouch time to wait");
        }
    }

    public String checkIfTittleIsContainedInBookList(String toPrintValueFromKey) {
        HashMap<String, String> titleAndAuthor = new HashMap<String, String>();
        boolean isTitleFound=false;
        try {
            for (WebElement it : returnAllBook()) {

                if (!getBookTitle(it).equals(null)) {
                    titleAndAuthor.put(getBookTitle(it), getBookAuthor(it));
                }
            }
        } catch (NoSuchElementException | NullPointerException e) {
            //e.printStackTrace();
        } finally {
            for (String key : titleAndAuthor.keySet()) {
                if(key.equals(toPrintValueFromKey)){
                    isTitleFound=true;
                }
                break;
            }
        }
        String valueFromKey=titleAndAuthor.get(toPrintValueFromKey);
        return valueFromKey;
    }

    public void printListOfTytlesFromHashMapValues(String getKeyFromValue) {
        HashMap<String, String> titleAndAuthor = new HashMap<String, String>();
        try {
            for (WebElement it : returnAllBook()) {
                if (!getBookTitle(it).equals(null)) {
                    titleAndAuthor.put(getBookTitle(it), getBookAuthor(it));
                }
            }
        } catch (NoSuchElementException | NullPointerException e) {

        } finally {
            for (Entry<String, String> entry : titleAndAuthor.entrySet()) {
                if(entry.getValue().equals(getKeyFromValue)){
                    System.out.println(entry.getKey());
                    break;
                }
            }
        }
    }

    public int assertNullNumber() {
        int isElementNotNull=0;
        HashMap<String, String> titleAndAuthor = new HashMap<String, String>();
        try {
            for (WebElement it : returnAllBook()) {
                if (!getBookTitle(it).equals(null)) {
                    titleAndAuthor.put(getBookTitle(it), getBookAuthor(it));
                    isElementNotNull++;
                }
            }
        } catch (NoSuchElementException | NullPointerException e){

        }
        return isElementNotNull;
    }
    public int numberOfNotNullElements(){
        HashMap<String, String> titleAndAuthor = new HashMap<>();
        try{
            for(WebElement it:returnAllBook()){
                if (!getBookTitle(it).equals(null)) {
                    titleAndAuthor.put(getBookTitle(it), getBookAuthor(it));
                }
            }
        }catch(NoSuchElementException | NullPointerException e){

        }
        return titleAndAuthor.size();
    }

    public String printListOfBooks(String searchForWord) {
        String bookTitle = "";
        for (WebElement it : returnAllBook()) {
            try {
                bookTitle = getBookTitle(it);
            } catch (NullPointerException e) {

            } finally {
                if (bookTitle != null) {
                    Assert.assertTrue(bookTitle.toLowerCase().contains(searchForWord), "Title doesn't contain the imputed string");
                    System.out.println(bookTitle);
                }
            }
        }
        return bookTitle;
    }

    public void checkEmptyBookList() {
        for (WebElement it : returnAllBook()) {
            String bookTitle = "";
            try {
                bookTitle = getBookTitle(it);
            } catch (NoSuchElementException e) {
            }
            if (bookTitle == "") {
                System.out.println("Empty book list ");
                break;
            }
        }
    }

    public void checkForDifferentBooks(String bookStringSearch){
        searchBox.sendKeys(bookStringSearch);
        System.out.println(bookStringSearch);
    }

    public String splitUrl(String currentUrl){
        String newURL = currentUrl.substring(currentUrl.lastIndexOf("?")+1);
        String lastSplitURL = newURL.substring(newURL.lastIndexOf("=")+1);
        return lastSplitURL;
    }

    public boolean clickSelectedBook(String bookTitleSearchSelect) {
        List <WebElement> titleLinks = returnAllTitles();
        boolean isDisplayed=false;
        try {
            for (WebElement it : titleLinks) {

                if(it.getText().equals(bookTitleSearchSelect)) {
                    it.click();
                    isDisplayed=true;
                }
            }
        } catch (NoSuchElementException | NullPointerException | org.openqa.selenium.StaleElementReferenceException e){
            //e.printStackTrace();
        }
        return isDisplayed;
    }

    public String clickSelectedBookFromList (String bookTitleSearchSelect) {
        List <WebElement> titleLinks = returnAllTitles();
        String bookTitle="";
        try {
            for (WebElement it : titleLinks) {
                if(it.getText().equals(bookTitleSearchSelect)) {
                    bookTitle=it.getText();
                    it.click();
                }
            }
        } catch (NoSuchElementException | NullPointerException | org.openqa.selenium.StaleElementReferenceException e){
            //e.printStackTrace();
        }
        return bookTitle;
    }

    public void clickOnRandomBookTitle () {
        Random rand = new Random();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int maxIndex = returnAllTitles().size();
        int int_random = rand.nextInt(maxIndex);
        try {
            if(int_random>2){
                js.executeScript("window.scrollBy(0,1000)");
            }
            Thread.sleep(5000);
            returnAllTitles().get(int_random).click();

        } catch (NoSuchElementException | NullPointerException | InterruptedException e){
            //e.printStackTrace();
        }
    }

}


//Recomandare
// -> spell checks!
// -> naming conventions (double check)