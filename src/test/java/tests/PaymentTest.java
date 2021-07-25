package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class PaymentTest extends BaseTest {
    @Test(description = "purchase of goods", priority = 1)
    public void purchaseOfGoods() {
        authenticationPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        myAccountPage.clickHomeButton();
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        cartPage.clickProceedCheckoutButton();
        addressPage.clickProceedCheckoutButton();
        shippingPage.clickCheckboxOnShippingPage()
                .clickProceedCheckoutButton();
        paymentPage.clickPayBYButton(PAY_BY);
        orderSummaryPage.clickIConfirmMyOrderButton();
        Assert.assertEquals(orderConfirmationPage.getOrderStatus(), ORDER_STATUS);
    }
}
