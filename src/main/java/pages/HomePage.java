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

    public static final String PRODUCT_ELEMENT_LOCATOR = "//*[contains(text(),'%s')]/ancestor::*[@class='product-container']";
    public static final String ADD_PRODUCT_LOCATOR = PRODUCT_ELEMENT_LOCATOR + "//a[contains(@class,'button ajax_add')]";
    public static final String MORE_BUTTON = PRODUCT_ELEMENT_LOCATOR + "//a[contains(@class,'button lnk_view')]";

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
     * @param productPrice String
     * @return ProductAddedToCartModalPage
     */
    @Step("click Add Product Button on the Home Page")
    public ProductAddedToCartModalPage clickAddProductButton(String productPrice) {
        scrollDown();
        log.info("click Add Product Button, Locator:" + ADD_PRODUCT_LOCATOR);
        mouseHover((By.xpath(String.format(PRODUCT_ELEMENT_LOCATOR, productPrice))), (By.xpath(String.format(ADD_PRODUCT_LOCATOR, productPrice))));
        return new ProductAddedToCartModalPage(driver);
    }

    /**
     * click More Button on Home Page
     *
     * @param productPrice String
     * @return ProductPage
     */
    @Step("click More Button on the Home Page")
    public ProductPage clickMoreButton(String productPrice) {
        scrollDown();
        log.info("click More Button, Locator:" + MORE_BUTTON);
        mouseHover((By.xpath(String.format(PRODUCT_ELEMENT_LOCATOR, productPrice))), (By.xpath(String.format(MORE_BUTTON, productPrice))));
        return new ProductPage(driver);
    }
}
