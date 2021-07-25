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

    public static final String PRODUCT_ITEM = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'cart_item')]";
    public static final String DELETE_BUTTON_LOCATOR = PRODUCT_ITEM + "/td[@class='cart_delete text-center']";
    public static final String ITEM_UNIT_PRICE_LOCATOR = PRODUCT_ITEM + "/td[@class='cart_unit']/span";
    public static final String ITEM_DESCRIPTION_LOCATOR = PRODUCT_ITEM + "/td[@class='cart_description']/small/a";
    public static final String ITEM_QUANTITY_LOCATOR = PRODUCT_ITEM + "/*[@class='cart_quantity text-center']/input[@type='hidden']";

    /**
     * is product in the cart
     *
     * @param productPrice String
     * @return true
     */
    public boolean isProductInCart(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("productPrice Locator = " + String.format(PRODUCT_ITEM, productPrice));
        return driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productPrice))).size() > 0;
    }

    /**
     * delete product from the Cart
     *
     * @param productPrice String
     * @return CartPage
     */
    @Step("click Delete Product Button on the Cart Page")
    public CartPage deleteProductFromCart(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("Click 'Delete' Button. Locator: " + String.format(DELETE_BUTTON_LOCATOR, productPrice));
        driver.findElement(By.xpath(String.format(DELETE_BUTTON_LOCATOR, productPrice))).click();
        waitUntilElementDisappears(By.xpath(String.format(DELETE_BUTTON_LOCATOR, productPrice)));
        return this;
    }

    /**
     * get Product Price on CartPage
     *
     * @param productPrice String
     * @return String
     */
    public String getPriceProduct(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("product price on CartPage. Locator: " + String.format(ITEM_UNIT_PRICE_LOCATOR, productPrice));
        return driver.findElement(By.xpath(String.format(ITEM_UNIT_PRICE_LOCATOR, productPrice))).getText();
    }

    /**
     * get Description Product
     *
     * @param productPrice String
     * @return String
     */
    public String getDescriptionProduct(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("Description price Locator: " + String.format(ITEM_DESCRIPTION_LOCATOR, productPrice));
        return driver.findElement(By.xpath(String.format(ITEM_DESCRIPTION_LOCATOR, productPrice))).getText();
    }

    /**
     * get product's quantity on Cart Page
     *
     * @param productPrice String
     * @return String
     */
    public String getProductQuantityOnCartPage(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("product's quantity on Cart Page Locator: " + String.format(ITEM_QUANTITY_LOCATOR, productPrice));
        return driver.findElement(By.xpath(String.format(ITEM_QUANTITY_LOCATOR, productPrice))).getAttribute("value");
    }
}
