package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    WebDriver driver;
    String label;
    private static final String INPUT_TEXT_AREA_LOCATOR = "//*[contains(text(),'%s')]/ancestor::*[@class='textarea form-group']/textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * data entry for registration in text area
     *
     * @param text input text
     */
    public void writeTextArea(String text) {
        log.info(String.format("Type '%s' in text area field '%s'", text, label));
        driver.findElement(By.xpath(String.format(INPUT_TEXT_AREA_LOCATOR, label))).sendKeys(text);
    }
}
