package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Checkbox {
    WebDriver driver;
    String label;
    private static final String CHECKBOX_LOCATOR = "//*[contains(text(),'%s')]/ancestor::*[@class='checkbox']//input";

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * click Checkbox
     */
    public void clickCheckbox() {
        log.info("click Checkbox. Locator:" + CHECKBOX_LOCATOR);
        driver.findElement(By.xpath(String.format(CHECKBOX_LOCATOR, label))).click();
    }
}
