package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
    WebDriver driver;
    public static final By HEADER_LOGO_LOCATOR = By.id("header");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * wait for page opened
     *
     * @param locator By locator
     */
    public void waitForPageOpened(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
