package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends HeaderPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_LOCATOR = "//*[@data-id-product='%s']";
    public static final String PRODUCT_INDEX = "//*[@data-id-product='%s']/ancestor::*[@class='product-container']";
    public static final String MORE_BUTTON = "//*[@data-id-product='%s']/ancestor::*[@class='button-container']/a[@title='View']";

    /**
     * open Home Page
     */
    @Step("Open Home page")
    public HomePage openPage() {
        log.info("Open Home page, URL:" + AUTOMATION_PRACTICE_BASE_URL);
        driver.get(AUTOMATION_PRACTICE_BASE_URL);
        waitForHeaderLogoDisplayed();
        return this;
    }

    /**
     * click Add Product Button on Home Page
     *
     * @param productNumber String
     * @return ProductAddedToCartModalPage
     */
    @Step("click 'Add Product Button'  productNumber = {productNumber} on the Home Page")
    public ProductAddedToCartModalPage clickAddProductButton(String productNumber) {
        scrollDown();
        log.info("click Add Product Button, Locator:" + String.format(ADD_PRODUCT_LOCATOR, productNumber));
        mouseHoverAndClick(By.xpath(String.format(PRODUCT_INDEX, productNumber)), By.xpath(String.format(ADD_PRODUCT_LOCATOR, productNumber)));
        return new ProductAddedToCartModalPage(driver);
    }

    /**
     * click More Button on Home Page
     *
     * @param productNumber String
     * @return ProductPage
     */
    @Step("click More Button productNumber = {productNumber} on the Home Page")
    public ProductPage clickMoreButton(String productNumber) {
        scrollDown();
        log.info("click More Button, Locator:" + MORE_BUTTON);
        mouseHoverAndClick((By.xpath(String.format(PRODUCT_INDEX, productNumber))), (By.xpath(String.format(MORE_BUTTON, productNumber))));
        return new ProductPage(driver);
    }
}
