package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddressPage extends CheckoutCommonPage {
    public AddressPage(WebDriver driver) {
        super(driver);
    }
}
