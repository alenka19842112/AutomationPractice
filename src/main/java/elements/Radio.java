package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class Radio {
    WebDriver driver;
    String label;
    private static final String RADIO_LOCATOR = "//label[contains(.,'%s')]/descendant::*[@type='radio']";

    public Radio(WebDriver driver,String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * click Radio
     */
    public void clickRadio(){
        log.info("Choice Radio. Locator: " + String.format(RADIO_LOCATOR,label));
        driver.findElement(By.xpath(String.format(RADIO_LOCATOR, label))).click();
    }
}
