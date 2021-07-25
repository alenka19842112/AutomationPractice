package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
abstract class CheckoutCommonPage extends HeaderPage {
    public CheckoutCommonPage(WebDriver driver) {
        super(driver);
    }

    public static final By PROCEED_CHECKOUT_BUTTON = By.xpath("//*[contains(@class,'button btn btn-default')]");

    /**
     * click 'Proceed to checkout' Button
     */
    @Step("click 'Proceed to checkout' Button on the Page")
    public void clickProceedCheckoutButton() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Proceed to checkout' Button. Locator: " + PROCEED_CHECKOUT_BUTTON);
        driver.findElement(PROCEED_CHECKOUT_BUTTON).click();
    }
}
