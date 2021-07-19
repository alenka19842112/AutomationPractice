package pages;

import constans.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends HeaderPage implements IConstants {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'cart_item')]";
    public static final String DELETE_BUTTON_LOCATOR = PRODUCT_ITEM + "/td[@class='cart_delete text-center']";
    public static final By PROCEED_CHECKOUT_BUTTON = By.xpath("//*[contains(@class,'button btn')]");

    /**
     * is product in the cart
     *
     * @param productPrice String
     * @return true
     */
    public boolean isProductInCart(String productPrice) {
        waitForHeaderLogoDisplayed();
        log.info("productPrice Locator = " + PRODUCT_ITEM);
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
        log.info("Click 'Delete' Button. Locator: " + DELETE_BUTTON_LOCATOR);
        driver.findElement(By.xpath(String.format(DELETE_BUTTON_LOCATOR, productPrice))).click();
        waitUntilElementDisappears(By.xpath(String.format(DELETE_BUTTON_LOCATOR, productPrice)));
        return this;
    }

    /**
     * click 'Proceed to checkout' Button on the Cart Page
     *
     * @return AddressPage
     */
    @Step("click 'Proceed to checkout' Button on the Cart Page")
    public AddressPage clickProceedCheckoutButtonOnCartPage() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Proceed to checkout' Button. Locator: " + PROCEED_CHECKOUT_BUTTON);
        driver.findElement(PROCEED_CHECKOUT_BUTTON).click();
        return new AddressPage(driver);
    }
}
