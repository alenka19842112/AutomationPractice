package pages;

import constans.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage implements IConstants {

    public static final By HEADER_LOGO_LOCATOR = By.id("header");
    public static final By SIGN_OUT_BUTTON = By.xpath("//*[@class='logout']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * wait for Header Logo displayed
     *
     */
    public void waitForHeaderLogoDisplayed() {
        waitForElementVisible(HEADER_LOGO_LOCATOR);
    }
}
