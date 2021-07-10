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
     * Is displayed Sign Out Button?
     *
     * @return true
     */
    public boolean isDisplayedSignOutButton() {
        return new WebDriverWait(driver, 3)
               .until(ExpectedConditions.invisibilityOfElementLocated(HEADER_LOGO_LOCATOR));
    }
}
