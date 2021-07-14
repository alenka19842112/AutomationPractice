package pages;

import constans.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class HeaderPage extends BasePage implements IConstants {

    public static final By HEADER_LOGO_LOCATOR = By.id("header");
    public static final By SIGN_OUT_BUTTON = By.xpath("//*[@class='logout']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * wait for Header Logo displayed
     */
    public void waitForHeaderLogoDisplayed() {
        waitForElementVisible(HEADER_LOGO_LOCATOR);
    }

    /**
     * Is Sign Out Button displayed?
     *
     * @return true
     */
    public boolean isSignOutButtonDisplayed() {
        return new WebDriverWait(driver, 5)
               .until(ExpectedConditions.invisibilityOfElementLocated(SIGN_OUT_BUTTON));
    }

    /**
     * log out
     *
     * @return Login Page
     */
    @Step("Click 'Sign Out' button and log out")
    public LoginPage signOut() {
        log.info("click Sign Out button. Locator: " + SIGN_OUT_BUTTON);
        driver.findElement(SIGN_OUT_BUTTON).click();
        return new LoginPage(driver);
    }
}
