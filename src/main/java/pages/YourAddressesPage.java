package pages;

import elements.*;
import io.qameta.allure.Step;
import object.Account;
import org.openqa.selenium.WebDriver;

public class YourAddressesPage extends HeaderPage {
    public YourAddressesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * update address on Your Addresses Page
     *
     * @param account data account
     * @return MyAddressesPage
     */
    @Step("update Address on Your Addresses Page")
    public MyAddressesPage updateAddress(Account account) {
        new Input(driver, "Address").clearText();
        new Input(driver, "Address").writeText(account.getAddress());
        new Button(driver, "Save").clickButton();
        return new MyAddressesPage(driver);
    }
}
