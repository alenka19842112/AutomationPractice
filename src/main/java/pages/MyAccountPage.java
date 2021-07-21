package pages;

import constans.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyAccountPage extends HeaderPage implements IConstants {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By HOME_BUTTON = By.xpath("//*[@title='Home']");
    public static final By ACCOUNT_NAME_BUTTON = By.xpath("//*[@class='account']");

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
}
