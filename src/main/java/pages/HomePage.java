package pages;

import constans.IConstance;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends HeaderPage implements IConstance {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * open Page "http://automationpractice.com/"
     */
    @Step("Open Home page")
    public HomePage openPage() {
        log.info("Open Home page, URL:" + AUTOMATION_PRACTICE_BASE_URL);
        driver.get(AUTOMATION_PRACTICE_LOGIN_URL);
        waitForPageOpened(HEADER_LOGO_LOCATOR);
        return this;
    }
}
