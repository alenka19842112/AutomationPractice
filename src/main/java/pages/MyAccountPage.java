package pages;

import constans.IConstants;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends HeaderPage implements IConstants {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * get My Account Page Url
     *
     * @return url "http://automationpractice.com/index.php?controller=my-account"
     */
    public String getMyAccountPageUrl() {
        return getCurrentUrl();
    }
}
