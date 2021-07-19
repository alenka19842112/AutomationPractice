package tests;

import constans.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {

    @Test(description = "add product to Cart Test", priority = 1)
    public void addProductToCartTest(){
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.isProductInCart(PRODUCT_PRICE));
    }

    @Test(description = "delete product from the Cart Test", priority = 1)
    public void deleteProductFromCartTest(){
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        cartPage.deleteProductFromCart(PRODUCT_PRICE);
        Assert.assertFalse(cartPage.isProductInCart(PRODUCT_PRICE));
    }
}
