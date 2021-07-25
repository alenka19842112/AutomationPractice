package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AuthenticationPage extends HeaderPage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public static final By CREATE_BUTTON = By.id("SubmitCreate");
    public static final By LOGIN_BUTTON = By.id("SubmitLogin");
    public static final By EMAIL_CREATE_LOCATOR = By.id("email_create");
    public static final By EMAIL_INPUT_LOCATOR = By.id("email");
    public static final By PASSWORD_INPUT_LOCATOR = By.id("passwd");
    public static final String ERROR_MESSAGE_LOCATOR = "//*[text()='%s']/ancestor::*[contains(@class,'alert-danger')]";

    /**
     * login in site http://automationpractice.com/
     *
     * @param email    enter email address
     * @param password enter password
     * @return HomePage
     */
    @Step("Fill in {email} and {password} in Login field")
    public MyAccountPage login(String email, String password) {
        clickSignInButton();
        waitForElementVisible(LOGIN_BUTTON);
        log.info(String.format("fill in Email address: '%s' in Login field.", email));
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        log.info(String.format("fill in password: '%s' in Login field.", password));
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        log.info("click Login button. Locator:" + LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        return new MyAccountPage(driver);
    }

    /**
     * error message when entering invalid data in authentication field
     *
     * @param message String
     * @return text error message
     */
    @Step("Error message when entering invalid data in authentication field")
    public String getErrorMessageText(String message) {
        log.info("Locator: " + ERROR_MESSAGE_LOCATOR);
        return driver.findElement(By.xpath(String.format(ERROR_MESSAGE_LOCATOR, message))).getText();
    }

    /**
     * click 'create an account' button in Create an account field
     *
     * @param email enter email address
     * @return CreateAnAccountPage
     */
    @Step("Fill in {email} in Create an account field and click 'Create an account' button")
    public CreateAnAccountPage clickCreateAccountButton(String email) {
        clickSignInButton();
        waitForElementVisible(CREATE_BUTTON);
        log.info(String.format("fill in Email address: '%s' in Create an account field.", email));
        driver.findElement(EMAIL_CREATE_LOCATOR).sendKeys(email);
        log.info("click Create an account button. Locator:" + CREATE_BUTTON);
        driver.findElement(CREATE_BUTTON).click();
        return new CreateAnAccountPage(driver);
    }
}
