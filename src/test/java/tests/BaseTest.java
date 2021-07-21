package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    AuthenticationPage authenticationPage;
    HomePage homePage;
    HeaderPage headerPage;
    MyAccountPage myAccountPage;
    SearchPage searchPage;
    ProductAddedToCartModalPage productAddedToCartModalPage;
    CartPage cartPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmationPage;
    CreateAnAccountPage createAnAccountPage;

    /**
     * object initialization
     */
    public void init() {
        authenticationPage = new AuthenticationPage(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        searchPage = new SearchPage(driver);
        productAddedToCartModalPage = new ProductAddedToCartModalPage(driver);
        cartPage = new CartPage(driver);
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
    }

    @BeforeMethod
    public void initTest() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.fatal("Fatal error: ChromeDriver is not found", e);
        }
        init();
        homePage.openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
