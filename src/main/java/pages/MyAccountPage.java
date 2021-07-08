package pages;

import constans.IConstance;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends HeaderPage implements IConstance {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * get My Account Page Url
     *
     * @return url "http://automationpractice.com/index.php?controller=my-account"
     */
    public String getMyAccountPageUrl() {
        return driver.getCurrentUrl();
    }
}
