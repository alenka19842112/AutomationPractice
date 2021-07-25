package pages;

import constans.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    /**
     * scroll down
     */
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)", "");
    }

    /**
     * mouse hover
     *
     * @param elementLocator By
     * @param locator        By
     */
    public void mouseHover(By elementLocator, By locator) {
        Actions builder = new Actions(driver);
        WebElement hoverElement = driver.findElement(elementLocator);
        builder.moveToElement(hoverElement).perform();
        driver.findElement(locator).click();
    }

    /**
     * wait until the element disappears
     *
     * @return true
     */
    public boolean waitUntilElementDisappears(By locator) {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
