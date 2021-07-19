package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    WebDriver driver;
    String label;

    public Button(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String BUTTON_LOCATOR = "//*[contains(text(),'%s')]/ancestor::button[@type='submit']";

    /**
     * click Button
     */
    public void clickButton() {
        driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label))).click();
    }
}
