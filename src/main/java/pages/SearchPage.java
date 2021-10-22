package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SearchPage extends HeaderPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static final By SEARCH_HEADING_LOCATOR = By.xpath("//*[@class='heading-counter']");
    public static final By SEARCH_TITLE_LOCATOR = By.xpath("//*[@class='lighter']");
    public static final By SEARCH_RESULT_LOCATOR = By.xpath(" //*[@class='product-container']");

    /**
     * search title result
     *
     * @return text title search
     */
    @Step("retrieved title")
    public String getSearchTitleResult() {
        waitForHeaderLogoDisplayed();
        log.info("Locator: " + SEARCH_TITLE_LOCATOR);
        return driver.findElement(SEARCH_TITLE_LOCATOR).getText();
    }

    /**
     * Search heading-counter result
     *
     * @return String text
     */
    @Step("Search heading-counter result")
    public String getSearchResult() {
        waitForHeaderLogoDisplayed();
        log.info("Search heading-counter result. Locator: " + SEARCH_HEADING_LOCATOR);
        return driver.findElement(SEARCH_HEADING_LOCATOR).getText();
    }

    /**
     * is Search results displayed
     *
     * @return true
     */
    public boolean isSearchResultsDisplayed() {
        waitForHeaderLogoDisplayed();
        return driver.findElement(SEARCH_RESULT_LOCATOR).isDisplayed();
    }

    /**
     * Search number of products found
     *
     * @return String result
     */
    @Step("Search number of products found")
    public int getSearchResultsQty() {
        waitForHeaderLogoDisplayed();
        log.info("Search number of products found. Locator: " + SEARCH_RESULT_LOCATOR);
        return driver.findElements(SEARCH_RESULT_LOCATOR).size();
    }
}
