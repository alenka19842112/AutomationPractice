package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductAddedToCartModalPage extends BasePage {
    public ProductAddedToCartModalPage(WebDriver driver) {
        super(driver);
    }

    public static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//*[@class='btn btn-default button button-medium']");

    /**
     * Click 'Proceed to checkout' button
     *
     * @return CartPage
     */
    @Step("Click 'Proceed to checkout' button on Product Added To Cart Modal Page")
    public CartPage clickProceedToCheckoutButton() {
        waitForElementVisible(PROCEED_TO_CHECKOUT_BUTTON);
        log.info("click 'Proceed to checkout' button. Locator: " + PROCEED_TO_CHECKOUT_BUTTON);
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return new CartPage(driver);
    }
}
