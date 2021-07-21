package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    HeaderPage headerPage;
    MyAccountPage myAccountPage;

    /**
     * object initialization
     */
    public void init() {
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
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
