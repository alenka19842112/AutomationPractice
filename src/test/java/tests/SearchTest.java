package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "input text in search field", priority = 1)
    public void resultSearchTest() {
        headerPage.searchInputAndClickSearchButton("dress");
        Assert.assertEquals(searchPage.getSearchTitleResult(), "\"DRESS\"");
        Assert.assertTrue(searchPage.isSearchResultsDisplayed());
        Assert.assertEquals(searchPage.getSearchResult(), searchPage.getSearchResultsQty() + " results have been found.");
    }

    @Test(description = "empty line input in search field", priority = 1)
    public void emptyInputResultSearchTest() {
        headerPage.searchInputAndClickSearchButton("");
        Assert.assertEquals(searchPage.getSearchResult(), searchPage.getSearchResultsQty() + " results have been found.");
    }
}
