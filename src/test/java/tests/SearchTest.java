package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest implements ITestConstants {

    @Test(description = "input text in search field", priority = 1)
    public void retrievedTitleTest() {
        headerPage.searchInputAndClickSearchButton("dress");
        Assert.assertEquals(searchPage.getSearchTitleResult(), "\"DRESS\"");
    }

    @Test(description = "input text in search field", priority = 1)
    public void resultSearchTest() {
        headerPage.searchInputAndClickSearchButton("dress");
        Assert.assertTrue(searchPage.isResultSearch());
    }

    @Test(description = "empty line input in search field", priority = 1)
    public void emptyInputResultSearchTest() {
        headerPage.searchInputAndClickSearchButton("");
        Assert.assertFalse(searchPage.isResultSearch());
    }

    @Test(description = "comparison of the number of products with the title", priority = 1)
    public void comparisonWithTitleSearchResultTest() {
        headerPage.searchInputAndClickSearchButton("short");
        Assert.assertEquals(searchPage.getSearchResult(), searchPage.resultSearch());
    }
}
