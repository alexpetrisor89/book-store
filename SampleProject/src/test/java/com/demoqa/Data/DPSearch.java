package com.demoqa.Data;

import org.testng.annotations.DataProvider;

public class DPSearch {


    //aranjare corecta de date
    //mai multe scenarii de valid/invalid test
    //select a random item from the book list and select it + asserturs
    //random number picker for the above test.



    @DataProvider(name="searchForMultipleTitlesHappyFlow")
    public Object[] getSearchData(){
        return new Object[] {"","Learning JavaScript Design Patterns","java"};
    }

    @DataProvider(name = "SearchForMultipleTitlesNegativeFlow")
    public Object[] getSearchData1(){
        return new Object[] {"jaba", "@$#!", "ToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBarToLongStringInTheSearchBar" };
    }
}

