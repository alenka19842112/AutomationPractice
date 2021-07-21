package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest implements ITestConstants {

    @Test(description = "input text in search field", priority = 1)
    public void resultSearchTest() {
        headerPage.searchInputAndClickSearchButton("dress");
        Assert.assertEquals(searchPage.getSearchTitleResult(), "\"DRESS\"");
        Assert.assertTrue(searchPage.isResultSearch());
        Assert.assertEquals(searchPage.getSearchResult(), searchPage.resultSearch());
    }

    @Test(description = "empty line input in search field", priority = 1)
    public void emptyInputResultSearchTest() {
        headerPage.searchInputAndClickSearchButton("");
        Assert.assertFalse(searchPage.isResultSearch());
        Assert.assertEquals(searchPage.getSearchResult(), searchPage.resultSearch());
    }
}
