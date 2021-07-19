package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class PaymentTest extends BaseTest implements ITestConstants {
    @Test(description = "purchase of goods", priority = 1)
    public void purchaseOfGoods() {
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        myAccountPage.clickHomeButton();
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        cartPage.clickProceedCheckoutButtonOnCartPage();
        addressPage.clickProceedCheckoutButtonOnAddressPage();
        shippingPage.clickCheckboxOnShippingPage()
                .clickProceedCheckoutButtonOnShippingPage();
        paymentPage.clickPayBYButton(PAY_BY);
        orderSummaryPage.clickIConfirmMyOrderButton();
        Assert.assertEquals(orderConfirmationPage.getOrderStatus(),ORDER_STATUS);
    }
}
