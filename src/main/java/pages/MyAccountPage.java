package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyAccountPage extends HeaderPage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By HOME_BUTTON = By.xpath("//*[@title='Home']");
    public static final By ACCOUNT_NAME_BUTTON = By.xpath("//*[@class='account']");
    public static final By MY_ADDRESS_BUTTON = By.xpath("//*[@title='Addresses']");

    /**
     * click 'Home' Button on the My Account Page
     *
     * @return HomePage
     */
    @Step("click 'Home' Button on the My Account Page")
    public HomePage clickHomeButton() {
        waitForHeaderLogoDisplayed();
        log.info("click 'Home' Button on the My Account Page. Locator: " + HOME_BUTTON);
        driver.findElement(HOME_BUTTON).click();
        return new HomePage(driver);
    }

    /**
     * get Account name
     *
     * @return String Account name
     */
    public String getAccountName() {
        waitForHeaderLogoDisplayed();
        log.info("Locator: " + ACCOUNT_NAME_BUTTON);
        return driver.findElement(ACCOUNT_NAME_BUTTON).getText();
    }

    /**
     * click 'My Address' Button on the My Account Page
     *
     * @return MyAddressesPage
     */
    @Step("click 'My Address' Button on the My Account Page")
    public MyAddressesPage clickMyAddressButton() {
        waitForHeaderLogoDisplayed();
        log.info("Click 'My Address' Button on My account page. Locator: " + MY_ADDRESS_BUTTON);
        driver.findElement(MY_ADDRESS_BUTTON).click();
        return new MyAddressesPage(driver);
    }
}
