package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends CheckoutCommonPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_INDEX_LOCATOR = "//*[@class='cart_ref' and text()='SKU : demo_%s']";
    public static final String DELETE_BUTTON_LOCATOR = PRODUCT_INDEX_LOCATOR + "/ancestor::tr//td[@class='cart_delete text-center']";
    public static final String ITEM_UNIT_PRICE_LOCATOR = PRODUCT_INDEX_LOCATOR + "/ancestor::tr//td[@class='cart_unit']/span";
    public static final String ITEM_DESCRIPTION_LOCATOR = PRODUCT_INDEX_LOCATOR + "/ancestor::tr//td[@class='cart_description']/small/a";
    public static final String ITEM_QUANTITY_LOCATOR = PRODUCT_INDEX_LOCATOR + "/ancestor::tr/*[@class='cart_quantity text-center']/input[@type='hidden']";

    /**
     * is product in the cart
     *
     * @param productNumber String
     * @return true
     */
    public boolean isProductInCart(String productNumber) {
        waitForHeaderLogoDisplayed();
        log.info("productNumber Locator = " + String.format(PRODUCT_INDEX_LOCATOR, productNumber));
        return driver.findElement(By.xpath(String.format(PRODUCT_INDEX_LOCATOR, productNumber))).isDisplayed();
    }

    /**
     * delete product from the Cart
     *
     * @param productNumber String
     * @return CartPage
     */
    @Step("click Delete Product productNumber = {productNumber} Button on the Cart Page")
    public CartPage deleteProductFromCart(String productNumber) {
        waitForHeaderLogoDisplayed();
        log.info("Click 'Delete' Button. Locator: " + String.format(DELETE_BUTTON_LOCATOR, productNumber));
        driver.findElement(By.xpath(String.format(DELETE_BUTTON_LOCATOR, productNumber))).click();
        return this;
    }

    /**
     * is delete product in the cart
     *
     * @param productNumber String
     * @return true
     */
    public boolean isProductDeletedFromCart(String productNumber) {
        waitForHeaderLogoDisplayed();
        return waitUntilElementDisappears(By.xpath(String.format(PRODUCT_INDEX_LOCATOR, productNumber)));
    }

    /**
     * get Product Price on CartPage
     *
     * @param productNumber String
     * @return String
     */
    public String getPriceProduct(String productNumber) {
        waitForHeaderLogoDisplayed();
        log.info("product price on CartPage. Locator: " + String.format(ITEM_UNIT_PRICE_LOCATOR, productNumber));
        return driver.findElement(By.xpath(String.format(ITEM_UNIT_PRICE_LOCATOR, productNumber))).getText();
    }

    /**
     * get Description Product
     *
     * @param productNumber String
     * @return String
     */
    public String getDescriptionProduct(String productNumber) {
        waitForHeaderLogoDisplayed();
        log.info("Description price Locator: " + String.format(ITEM_DESCRIPTION_LOCATOR, productNumber));
        return driver.findElement(By.xpath(String.format(ITEM_DESCRIPTION_LOCATOR, productNumber))).getText();
    }

    /**
     * get product's quantity on Cart Page
     *
     * @param productNumber String
     * @return String
     */
    public String getProductQuantityOnCartPage(String productNumber) {
        waitForHeaderLogoDisplayed();
        log.info("product's quantity on Cart Page Locator: " + String.format(ITEM_QUANTITY_LOCATOR, productNumber));
        return driver.findElement(By.xpath(String.format(ITEM_QUANTITY_LOCATOR, productNumber))).getAttribute("value");
    }
}
