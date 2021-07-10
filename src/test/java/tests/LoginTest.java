package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest implements ITestConstants {

    @Test(description = "Login with correct data Test", priority = 1)
    public void inputOfCorrectDataTest() {
        loginPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountPage.getMyAccountPageUrl(), AUTOMATION_PRACTICE_ACCOUNT_URL);
    }

    @Test(description = "Login with incorrect email address Test", priority = 2)
    public void inputOfIncorrectEmailTest() {
        loginPage.login("", System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));

        Assert.assertEquals(loginPage.getErrorMessageText(ERROR_MESSAGE), ERROR_EMAIL_MESSAGE);
    }

    @Test(description = "Login with incorrect password Test", priority = 2)
    public void inputOfIncorrectPasswordTest() {
        loginPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")), "");
        Assert.assertEquals(loginPage.getErrorMessageText(ERROR_MESSAGE), ERROR_PASSWORD_MESSAGE);
    }
}
