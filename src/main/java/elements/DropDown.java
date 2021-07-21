package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    private static final String DROPDOWN_DATE_OF_BIRTH = "//*[@class='col-xs-4']/descendant::*[contains(@id,'%s')]";
    private static final String DROPDOWN = "//*[contains(text(),'%s')]/ancestor::p[contains(@class,'select')]";
    private static final String SELECT_OPTION_XPATH = "//*[contains(@class,'selector')]/descendant::*[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * selection from the dropdown Date of Birth
     *
     * @param option select option
     */
    @Step("selection from the dropdown Date of Birth")
    public void selectDateOfBirth(String option) {
        log.info("Locator: " + DROPDOWN_DATE_OF_BIRTH);
        driver.findElement(By.xpath(String.format(DROPDOWN_DATE_OF_BIRTH, label))).click();
        log.info("Locator: " + SELECT_OPTION_XPATH);
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }

    /**
     * selection from the dropdown
     *
     * @param option select option
     */
    @Step("selection from the dropdown")
    public void select(String option) {
        log.info("Locator: " + DROPDOWN);
        driver.findElement(By.xpath(String.format(DROPDOWN, label))).click();
        log.info("Locator: " + SELECT_OPTION_XPATH);
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }
}
