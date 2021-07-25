package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OrderSummaryPage extends HeaderPage {
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public static final By MY_ORDER_BUTTON = By.xpath("//*[@class='button btn btn-default button-medium']");

    /**
     * Click 'I confirm my order' Button
     *
     * @return OrderConfirmationPage
     */
    @Step("Click 'Pay by' Button.")
    public OrderConfirmationPage clickIConfirmMyOrderButton() {
        waitForHeaderLogoDisplayed();
        log.info("Click 'I confirm my order' Button. Locator: " + MY_ORDER_BUTTON);
        driver.findElement(MY_ORDER_BUTTON).click();
        return new OrderConfirmationPage(driver);
    }
}
