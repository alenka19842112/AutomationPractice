package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaymentPage extends HeaderPage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public static final String PAY_BY_LOCATOR = "//*[contains(text(),'%s')]/ancestor::p[@class='payment_module']";

    /**
     * Click 'Pay by' Button
     *
     * @param payBy String
     * @return OrderSummaryPage
     */
    @Step("Click 'Pay by' Button.")
    public OrderSummaryPage clickPayBYButton(String payBy) {
        waitForHeaderLogoDisplayed();
        log.info("Click 'Pay by' Button. Locator: " + PAY_BY_LOCATOR);
        driver.findElement(By.xpath(String.format(PAY_BY_LOCATOR, payBy))).click();
        return new OrderSummaryPage(driver);
    }
}
