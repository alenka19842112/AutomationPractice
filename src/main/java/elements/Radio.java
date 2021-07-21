package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.xpath(String.format(RADIO_LOCATOR, label))).click();
    }
}
