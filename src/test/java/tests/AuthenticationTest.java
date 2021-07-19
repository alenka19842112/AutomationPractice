package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class AuthenticationTest extends BaseTest implements ITestConstants {

    @Test(description = "Login with correct data Test", priority = 1)
    public void inputOfCorrectDataTest() {
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountPage.getCurrentUrl(), AUTOMATION_PRACTICE_ACCOUNT_URL);
    }

    @Test(description = "Login with incorrect email address Test", priority = 1)
    public void inputOfIncorrectEmailTest() {
        authenticationPage.login("", System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));

        Assert.assertEquals(authenticationPage.getErrorMessageText(ERROR_MESSAGE), ERROR_EMAIL_MESSAGE);
    }

    @Test(description = "Login with incorrect password Test", priority = 1)
    public void inputOfIncorrectPasswordTest() {
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")), "");
        Assert.assertEquals(authenticationPage.getErrorMessageText(ERROR_MESSAGE), ERROR_PASSWORD_MESSAGE);
    }

    @Test(description = "input existing email in Create field Test", priority = 1)
    public void inputExistingEmailInCreateTest() {
        authenticationPage.clickCreateAccountButton(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")));
        Assert.assertEquals(authenticationPage.getErrorMessageText(ERROR_CREATE_ACCOUNT_USING) + " ", ERROR_CREATE_ACCOUNT_USING);
    }

    @Test(description = "input incorrect email in Create field Test", priority = 1)
    public void inputIncorrectEmailInCreateTest() {
        authenticationPage.clickCreateAccountButton("");
        Assert.assertEquals(authenticationPage.getErrorMessageText(ERROR_CREATE_MESSAGE), ERROR_CREATE_MESSAGE);
    }
}
