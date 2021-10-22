package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderPage extends BasePage {

    public static final By HEADER_LOGO_LOCATOR = By.id("header");
    public static final By SIGN_OUT_BUTTON = By.xpath("//*[@class='logout']");
    public static final By SIGN_IN_BUTTON = By.xpath("//*[@class='login']");
    public static final By SEARCH_LOCATOR = By.id("search_query_top");
    public static final By SEARCH_BUTTON = By.xpath("//*[@class='btn btn-default button-search']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * wait for Header Logo displayed
     */
    public void waitForHeaderLogoDisplayed() {
        waitForElementVisible(HEADER_LOGO_LOCATOR);
    }

    /**
     * Is Sign Out Button displayed?
     *
     * @return true
     */
    public boolean isSignOutButtonDisplayed() {
        return waitUntilElementDisappears(SIGN_OUT_BUTTON);
    }

    /**
     * log out
     *
     * @return Login Page
     */
    @Step("Click 'Sign Out' button and log out")
    public AuthenticationPage signOut() {
        log.info("click Sign Out button. Locator: " + SIGN_OUT_BUTTON);
        driver.findElement(SIGN_OUT_BUTTON).click();
        return new AuthenticationPage(driver);
    }

    /**
     * Click 'Sign In' button
     *
     * @return Login Page
     */
    @Step("Click 'Sign In' button")
    public AuthenticationPage clickSignInButton() {
        waitForHeaderLogoDisplayed();
        log.info("click Sign In button. Locator: " + SIGN_IN_BUTTON);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new AuthenticationPage(driver);
    }

    /**
     * search input and click 'Search' button
     *
     * @param text String
     * @return Search Page
     */
    @Step("Search {text} in input and click 'Search' button")
    public SearchPage searchForText(String text) {
        waitForHeaderLogoDisplayed();
        log.info(String.format("Input search text: '%s' in Search field.", text));
        driver.findElement(SEARCH_LOCATOR).sendKeys(text);
        log.info("click Search button. Locator: " + SEARCH_BUTTON);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }
}
