package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Click Button. Locator: " + String.format(BUTTON_LOCATOR, label));
        driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label))).click();
    }
}
