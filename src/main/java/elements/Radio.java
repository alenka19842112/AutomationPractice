package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Radio {
    WebDriver driver;
    String label;
    private static final String RADIO_LOCATOR = "";
    public static final By RADIO_MR_LOCATOR = By.id("id_gender1");
    public static final By RADIO_MRS_LOCATOR = By.id("id_gender2");

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
