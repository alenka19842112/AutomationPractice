package pages;

import constans.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ShippingPage extends CheckoutCommonPage implements IConstants {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public static final By CHECKBOX_LOCATOR = By.id("cgv");

    /**
     * click 'I agree to the terms of service and will adhere to them unconditionally.' Checkbox on the Shipping Page
     *
     * @return ShippingPage
     */
    @Step("click 'I agree to the terms of service and will adhere to them unconditionally.' Checkbox on the Shipping Page")
    public ShippingPage clickCheckboxOnShippingPage() {
        waitForHeaderLogoDisplayed();
        log.info("click Checkbox on the Shipping Page. Locator: " + CHECKBOX_LOCATOR);
        driver.findElement(CHECKBOX_LOCATOR).click();
        return this;
    }
}
