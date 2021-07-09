package pages;

import constans.IConstance;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends HeaderPage implements IConstance {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By SIGN_IN_BUTTON = By.xpath("//*[@class='login']");
    public static final By CREATE_BUTTON = By.id("SubmitCreate");
    public static final By LOGIN_BUTTON = By.id("SubmitLogin");
    public static final By EMAIL_CREATE_LOCATOR = By.id("email_create");
    public static final By EMAIL_INPUT_LOCATOR = By.id("email");
    public static final By PASSWORD_INPUT_LOCATOR = By.id("passwd");
    public static final String ERROR_MESSAGE_LOCATOR = "//*[text()='%s']/ancestor::*[@class='alert alert-danger']";
    public static final By CREATE_ACCOUNT_ERROR_MESSAGE_LOCATOR = By.id("create_account_error");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@class='logout']");

    /**
     * login in site http://automationpractice.com/
     *
     * @param email    enter email address
     * @param password enter password
     * @return HomePage
     */
    @Step("Click 'Sign In' button and fill in {email} and {password} in Login field")
    public HomePage login(String email, String password) {
        log.info("click Sign In button. Locator: " + SIGN_IN_BUTTON);
        driver.findElement(SIGN_IN_BUTTON).click();
        waitForPageOpened(LOGIN_BUTTON);
        log.info(String.format("fill in Email address: '%s' in Login field.", email));
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        log.info(String.format("fill in password: '%s' in Login field.", password));
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        log.info("click Login button. Locator:" + LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    /**
     * error message when entering invalid data
     *
     * @param message String
     * @return text error message
     */
    @Step("Error message  when entering invalid data")
    public String getErrorMessageText(String message) {
        return driver.findElement(By.xpath(String.format(ERROR_MESSAGE_LOCATOR, message))).getText();
    }
}
