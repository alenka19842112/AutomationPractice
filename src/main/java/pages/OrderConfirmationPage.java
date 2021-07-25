package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OrderConfirmationPage extends HeaderPage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public static final By ORDER_STATUS_LOCATOR = By.xpath("//*[@class='cheque-indent']");

    /**
     * Order Status
     *
     * @return String
     */
    public String getOrderStatus() {
        waitForElementVisible(ORDER_STATUS_LOCATOR);
        log.info("Locator: " + ORDER_STATUS_LOCATOR);
        return driver.findElement(ORDER_STATUS_LOCATOR).getText();
    }
}
