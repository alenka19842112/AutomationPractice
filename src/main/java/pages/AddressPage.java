package pages;

import constans.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddressPage extends HeaderPage implements IConstants {
    public AddressPage(WebDriver driver) {
        super(driver);
    }
    public static final By PROCEED_CHECKOUT_ON_ADDRESS_PAGE_BUTTON = By.xpath("//*[@class='button btn btn-default button-medium']");
    /**
     * click 'Proceed to checkout' Button on the Address Page
     *
     * @return ShippingPage
     */
    @Step("click 'Proceed to checkout' Button on the Address Page")
    public ShippingPage clickProceedCheckoutButtonOnAddressPage() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Proceed to checkout' Button on the Address Page. Locator: " + PROCEED_CHECKOUT_ON_ADDRESS_PAGE_BUTTON);
        driver.findElement(PROCEED_CHECKOUT_ON_ADDRESS_PAGE_BUTTON).click();
        return new ShippingPage(driver);
    }
}
