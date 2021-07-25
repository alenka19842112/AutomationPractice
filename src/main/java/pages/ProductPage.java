package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductPage extends HeaderPage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//*[@class='selector']");
    public static final String SIZE_OPTION_LOCATOR = "//*[@class='form-control attribute_select no-print']/option[@title='%s']";
    public static final String COLOR_LOCATOR = "//*[@name='%s']";
    public static final By PLUS_LOCATOR = By.xpath("//*[@class='icon-plus']");
    public static final By ADD_TO_CART_BUTTON = By.id("add_to_cart");
    public static final By PRICE_DISPLAY_LOCATOR = By.id("our_price_display");

    /**
     * click 'Plus' Button on the Product Page
     *
     * @return ProductPage
     */
    @Step("click 'Plus' Button on the Product Page")
    public ProductPage clickPlusButton() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Plus' Button on the Product Page, Locator:" + PLUS_LOCATOR);
        driver.findElement(PLUS_LOCATOR).click();
        return this;
    }

    /**
     * get 'Price on display' of Product on the Product Page
     *
     * @return String
     */
    public String getPriceDisplayProduct() {
        waitForHeaderLogoDisplayed();
        log.info("Price on display of Product on the Product Page, Locator:" + PRICE_DISPLAY_LOCATOR);
        return driver.findElement(PRICE_DISPLAY_LOCATOR).getText();
    }

    /**
     * selection from the dropdown Size
     *
     * @param option String
     * @return ProductPage
     */
    @Step("selection from the dropdown Size")
    public ProductPage selectSize(String option) {
        waitForHeaderLogoDisplayed();
        log.info("Choice DropDown Size. Locator: " + SIZE_DROPDOWN_LOCATOR);
        driver.findElement(SIZE_DROPDOWN_LOCATOR).click();
        log.info("Select option. Locator: " + String.format(SIZE_OPTION_LOCATOR, option));
        driver.findElement(By.xpath(String.format(SIZE_OPTION_LOCATOR, option))).click();
        return this;
    }

    /**
     * get Size on the Product Page
     *
     * @param option String
     * @return String
     */
    public String getSize(String option) {
        waitForHeaderLogoDisplayed();
        log.info("Select option. Locator: " + String.format(SIZE_OPTION_LOCATOR, option));
        return driver.findElement(By.xpath(String.format(SIZE_OPTION_LOCATOR, option))).getText();
    }

    /**
     * choice Color of product on the Product Page
     *
     * @param color String
     * @return ProductPage
     */
    @Step("choice Color {color} of product on the Product Page")
    public ProductPage clickColorButton(String color) {
        waitForHeaderLogoDisplayed();
        log.info("Color of product on the Product Page, Locator:" + String.format(COLOR_LOCATOR, color));
        driver.findElement(By.xpath(String.format(COLOR_LOCATOR, color))).click();
        return this;
    }

    /**
     * get attribute Color of product on the Product Page
     *
     * @param color String
     * @return String
     */
    public String getAttributeColor(String color) {
        waitForHeaderLogoDisplayed();
        log.info("Color of product on the Product Page, Locator:" + String.format(COLOR_LOCATOR, color));
        return driver.findElement(By.xpath(String.format(COLOR_LOCATOR, color))).getAttribute("name");
    }

    /**
     * click 'Add to cart' Button on the Product Page
     *
     * @return ProductPage
     */
    @Step("click 'Add to cart' Button on the Product Page")
    public ProductAddedToCartModalPage clickAddToCartButton() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Add to cart' Button on the Product Page, Locator:" + ADD_TO_CART_BUTTON);
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new ProductAddedToCartModalPage(driver);
    }
}
