package tests;

import constans.ITestAccountConstants;
import constans.ITestConstants;
import object.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CreateAnAccountTest extends BaseTest implements ITestConstants, ITestAccountConstants {

    @Test(priority = 1, description = "account creation test")
    public void createAccountTest() {
        Account account1 = new Account(FIRST_NAME,LAST_NAME,PASSWORD,DATE_OF_BIRTH_DAY,DATE_OF_BIRTH_MONTH,
                DATE_OF_BIRTH_YEAR,COMPANY,ADDRESS,CITY,STATE,ZIP_CODE, INFORMATION,MOBILE_PHONE);
        homePage.clickSignInButton();
        authenticationPage.clickCreateAccountButton(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("newEmail")));
        createAnAccountPage.create(account1);
        Assert.assertEquals(myAccountPage.getAccountName(),FIRST_NAME + " " + LAST_NAME);
    }
}
