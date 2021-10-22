package tests;

import constans.ITestAccountConstants;
import object.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class MyAddressTest extends BaseTest implements ITestAccountConstants {
    @Test(priority = 1, description = "update address on My Addresses Page  test")
    public void updateAddressTest() {
        Account account1 = new Account(NEW_ADDRESS);
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        myAccountPage.clickMyAddressButton();
        myAddressesPage.clickUpdateButton();
        yourAddressesPage.updateAddress(account1);
        Assert.assertEquals(myAddressesPage.getAddress(), NEW_ADDRESS);
    }
}
