package pages;

import constans.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddressPage extends CheckoutCommonPage implements IConstants {
    public AddressPage(WebDriver driver) {
        super(driver);
    }
}
