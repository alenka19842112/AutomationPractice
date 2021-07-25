package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyAddressesPage extends HeaderPage {
    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public static final By UPDATE_BUTTON = By.xpath("//*[@title='Update']");
    public static final By ADDRESS_LOCATOR = By.xpath("//*[@class='address_address1']");

    /**
     * Click 'Update' Button on My Addresses page
     *
     * @return YourAddressesPage
     */
    @Step("click 'Update' Button on the My Addresses Page")
    public YourAddressesPage clickUpdateButton() {
        waitForHeaderLogoDisplayed();
        log.info("Click 'Update' Button on My Addresses page. Locator: " + UPDATE_BUTTON);
        driver.findElement(UPDATE_BUTTON).click();
        return new YourAddressesPage(driver);
    }

    /**
     * get Address on My Addresses page
     *
     * @return String text
     */
    public String getAddress() {
        waitForHeaderLogoDisplayed();
        log.info("Locator: " + ADDRESS_LOCATOR);
        return driver.findElement(ADDRESS_LOCATOR).getText();
    }
}
