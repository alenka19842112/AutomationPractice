package pages;

import constans.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage implements IConstants {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * wait for page opened
     *
     * @param locator By locator
     */
    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * get current page Url
     *
     * @return url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
