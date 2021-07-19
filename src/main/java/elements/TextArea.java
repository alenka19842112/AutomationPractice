package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    private static final String INPUT_TEXT_AREA_LOCATOR = "//*[contains(text(),'%s')]/ancestor::*[@class='textarea form-group']";

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
        driver.findElement(By.xpath(String.format(INPUT_TEXT_AREA_LOCATOR, label))).sendKeys(text);
    }
}
