package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class HeaderTest extends BaseTest implements ITestConstants {

    @Test(description = "Log out Test", priority = 1)
    public void logOutTest() {
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        headerPage.signOut();
        Assert.assertTrue(headerPage.isSignOutButtonDisplayed());
    }
}
