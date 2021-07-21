package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {
    WebDriver driver;
    String label;
    private static final String INPUT_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'form')]/input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * data entry for registration
     *
     * @param text input text
     */
    public void writeText(String text) {
        log.info("Locator: " + INPUT_XPATH);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

}
