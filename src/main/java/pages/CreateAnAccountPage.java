package pages;

import elements.*;
import io.qameta.allure.Step;
import object.Account;
import org.openqa.selenium.WebDriver;

public class CreateAnAccountPage extends HeaderPage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    /**
     * create new Account in Modal Page
     *
     * @param account data account
     * @return MyAccountPage
     */
    @Step("filling in personal data")
    public MyAccountPage create(Account account) {
        new Radio(driver,"Mrs.").clickRadio();
        new Input(driver,"First name").writeText(account.getFirstName());
        new Input(driver,"Last name").writeText(account.getLastName());
        new Input(driver,"Password").writeText(account.getPassword());
        new DropDown(driver,"days").selectDateOfBirth(account.getDateOfBirthDay());
        new DropDown(driver,"month").selectDateOfBirth(account.getDateOfBirthMonth());
        new DropDown(driver,"year").selectDateOfBirth(account.getDateOfBirthYear());
        new Checkbox(driver, "Sign up for our newsletter!").clickCheckbox();
        new Checkbox(driver, "Receive special offers from our partners!").clickCheckbox();
        new Input(driver,"Company").writeText(account.getCompany());
        new Input(driver,"Address").writeText(account.getAddress());
        new Input(driver,"City").writeText(account.getCity());
        new DropDown(driver,"State").select(account.getState());
        new Input(driver,"Zip/Postal Code").writeText(account.getZipCode());
        new TextArea(driver,"Additional information").writeTextArea(account.getInformation());
        new Input(driver,"Mobile phone").writeText(account.getMobilePhone());
        new Button(driver, "Register").clickButton();
        return new MyAccountPage(driver);
    }
}
