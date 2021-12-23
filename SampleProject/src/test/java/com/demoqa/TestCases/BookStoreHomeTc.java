package com.demoqa.TestCases;

import com.demoqa.Utils.BrowserSetup;
import com.demoqa.Pages.BookDetailsPo;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demoqa.Data.DPSearch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BookStoreHomeTc extends TCBaseTest {


    BrowserSetup browserst;
    WebElement element;
    DPSearch dpSearch;
    BookDetailsPo bookDetailsObj;


    public BookStoreHomeTc() {
        super();
    }

    @Test
    public void checkForEmpyList() throws InterruptedException {
        homeObj.addTextToSearchBox("no search data");
        String isEmpty = homeObj.searchForEmptyBookList();
        homeObj.waitForElementToBeVisible("div.rt-tbody > div:nth-child(1) > div > div:nth-child(2)");
        Assert.assertEquals(isEmpty, " ", "The list is empty");

    }

    @Test
    public void checkForNotEmpyList() {
        homeObj.addTextToSearchBox("java");
        String isNotEmpty = homeObj.searchForEmptyBookList();
        homeObj.waitForElementToBeVisible("div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(2) > div");
        Assert.assertEquals(isNotEmpty, "Learning JavaScript Design Patterns", "The list is not empty");
    }

    @Test
    public void getListOfSearchedBooks(){
        homeObj.addTextToSearchBox("java");
        homeObj.printListOfBooks("java");

    }

    @Test
    public void getListOfTitleAndAuthor(){
        homeObj.addTextToSearchBox("java");
        String valueFromKey = homeObj.checkIfTittleIsContainedInBookList("Learning JavaScript Design Patterns");
        Assert.assertTrue(valueFromKey.contains("Addy"), "Invalid book search");
        System.out.println(valueFromKey);
    }

    @Test
    public void getListOfTitleFromAuthorValues(){
        homeObj.addTextToSearchBox("java");
        homeObj.printListOfTytlesFromHashMapValues("Addy Osmani");
    }

    @Test
    public void checkForEmptyBookList(){
        homeObj.addTextToSearchBox("nosearchdata");
        homeObj.checkEmptyBookList();
    }
    @Test
    public void checkForNullElements(){
        homeObj.addTextToSearchBox("java");
        int noOfNotNullItemms=homeObj.assertNullNumber();
        int iterateNumberOfBooksInHashMap=homeObj.numberOfNotNullElements();
        Assert.assertEquals(noOfNotNullItemms, iterateNumberOfBooksInHashMap, "Number of not null items is not equals with the number of items in the HashMap");
    }

    @Test
    public void simpleBookSearch() throws InterruptedException {
        homeObj.addTextToSearchBox("java".toLowerCase());
        Thread.sleep(100);
        homeObj.selectBookTitle();
        String actualAuthor = (driver.findElement(By.cssSelector("#author-wrapper > div.col-md-9.col-sm-12")).getText());
        String actualPublisher = (driver.findElement(By.cssSelector("#publisher-wrapper > div.col-md-9.col-sm-12")).getText());
        String expectedAuthor = "Addy Osmani";
        String expectedPublisher = "O'Reilly Media";
        Assert.assertEquals(actualAuthor, expectedAuthor, "Values do not match");
        Assert.assertEquals(expectedPublisher, actualPublisher, "Values do not match");

    }

    @Test
            (dataProviderClass = DPSearch.class,
            dataProvider = "searchForMultipleTitlesHappyFlow",
            enabled = false
            )
    //requires updates
    public void searchForBooks(String bookSearch)throws InterruptedException{
        homeObj.checkForDifferentBooks(bookSearch);
        String isOrIsNotEmpty = homeObj.searchForEmptyBookList();
        Thread.sleep(1000);
        homeObj.waitForElementToBeVisible("div.rt-tbody > div:nth-child(1) > div > div:nth-child(2)");
        Assert.assertEquals(isOrIsNotEmpty, "", "The list is empty");
        homeObj.waitForElementToBeVisible("div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(2) > div");
        Assert.assertEquals(isOrIsNotEmpty, "Learning JavaScript Design Patterns", "The list is not empty");
    }

    @Test
    public void urlSplit() throws InterruptedException {
        homeObj.addTextToSearchBox("java");
        homeObj.selectBookTitle();
        Thread.sleep(1000);
        String curentTitletUrl = driver.getCurrentUrl();
        System.out.println("Your URL is: "+curentTitletUrl);
        String currentURL = homeObj.splitUrl(curentTitletUrl);
        System.out.println(currentURL);
    }

    @Test
    public void compareTitleHromBookSearchWithSelectedBook() throws InterruptedException {
        homeObj.addTextToSearchBox("java");
        String authorFromSeachPage=driver.findElement(By.cssSelector("div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(3)")).getText();
        String titleFromSearchage=driver.findElement(By.cssSelector("div.rt-table >div.rt-tbody > div:nth-child(1) > div > div:nth-child(2)")).getText();
        homeObj.selectBookTitle();
        Thread.sleep(1000);
        String authorFromBookPage = driver.findElement(By.cssSelector("#author-wrapper > div.col-md-9.col-sm-12")).getText();
        String titleFromBookPage = driver.findElement(By.cssSelector("#title-wrapper > div.col-md-9.col-sm-12")).getText();
        Assert.assertTrue(authorFromSeachPage.equals(authorFromBookPage), "Author from homepage doesn't match author from book page");
        Assert.assertTrue(titleFromSearchage.equals(titleFromBookPage), "Title from homepage doesn't match title from book page");

    }

    @Test
    public void selectBookTitleAndAssertISBN() throws InterruptedException {
        boolean isTitleAAvailalbe=homeObj.clickSelectedBook("Learning JavaScript Design Patterns");
        Assert.assertEquals(isTitleAAvailalbe,true,  "Title was not found in the book list");
        String curentTitletUrl = driver.getCurrentUrl();
        String currentUrlString=(homeObj.splitUrl(curentTitletUrl));
        bookDetailsObj = new BookDetailsPo(driver);
        String isbn=bookDetailsObj.getIsbn().getText();
        Thread.sleep(1000);
        Assert.assertEquals(currentUrlString,isbn, "URL numeric ISBN string and ISBN from BookDetails page are not the same");
    }

    @Test
    public void selectBookTitleFromHashMap(){
        String valueFromKey = homeObj.checkIfTittleIsContainedInBookList("Learning JavaScript Design Patterns");
        String valueFromValue = homeObj.clickSelectedBookFromList("Learning JavaScript Design Patterns");
        bookDetailsObj = new BookDetailsPo(driver);
        Assert.assertEquals(valueFromKey, bookDetailsObj.getAuthor().getText(), "error");
        Assert.assertEquals(valueFromValue, bookDetailsObj.getTitle().getText(), "error");

    }

    @Test
    public void clickOnRandomBookTitle() {
        bookDetailsObj = new BookDetailsPo(driver);
        homeObj.addTextToSearchBox("java");
        String isEmpty = homeObj.searchForEmptyBookList();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(isEmpty);
        if(!isEmpty.equals(" ")){
            homeObj.clickOnRandomBookTitle();
            String isbn=bookDetailsObj.getIsbn().getText();
            String curentTitletUrl = driver.getCurrentUrl();
            Assert.assertTrue(curentTitletUrl .contains(isbn), "ISBN not the same with the ISBN string from URL");
            System.out.println(curentTitletUrl);
        }else {
            System.out.println("The row is empty");
        }
    }


    @Test(dataProviderClass = DPSearch.class,
            dataProvider = "searchForMultipleTitlesHappyFlow")
    public void clickOnRandomBookTitleViaDP(String searchForMultipleTitlesHappyFlow) {
        bookDetailsObj = new BookDetailsPo(driver);
        homeObj.addTextToSearchBox(searchForMultipleTitlesHappyFlow);
        String isEmpty = homeObj.searchForEmptyBookList();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(isEmpty);
        if(!isEmpty.equals(" ")){
            homeObj.clickOnRandomBookTitle();
            String isbn=bookDetailsObj.getIsbn().getText();
            String curentTitletUrl = driver.getCurrentUrl();
            Assert.assertTrue(curentTitletUrl .contains(isbn), "ISBN not the same with the ISBN string from URL");
            System.out.println(curentTitletUrl);
        }else {
            Assert.assertEquals(isEmpty, " ", "The book list is empty");
        }
    }

    @Test(dataProviderClass = DPSearch.class,
            dataProvider = "SearchForMultipleTitlesNegativeFlow")
    public void CheckBookListVithInvalidCharacters(String SearchForMultipleTitlesNegativeFlow) {
        bookDetailsObj = new BookDetailsPo(driver);
        homeObj.addTextToSearchBox(SearchForMultipleTitlesNegativeFlow);
        String isEmpty = homeObj.searchForEmptyBookList();
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(SearchForMultipleTitlesNegativeFlow);
        boolean b = m.find();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(SearchForMultipleTitlesNegativeFlow.length()>45){
            System.out.println("You passed the limit of characters accepted in the search box");
        }else if(b) {
            System.out.println("Tere are special characters added in the search box, please remove them and search again");;
        } else{
            Assert.assertNotEquals(isEmpty, "", "You typed in a wrong search wor, please recheck it.");
        }
    }

    @Test
    public void clickOnRandomBookTitldase() {
    }
}