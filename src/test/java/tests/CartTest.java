package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "add product to Cart Test", priority = 1)
    public void addProductToCartTest() {
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.isProductInCart(PRODUCT_PRICE));
    }

    @Test(description = "delete product from the Cart Test", priority = 1)
    public void deleteProductFromCartTest() {
        homePage.clickAddProductButton(PRODUCT_PRICE);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        cartPage.deleteProductFromCart(PRODUCT_PRICE);
        Assert.assertFalse(cartPage.isProductInCart(PRODUCT_PRICE));
    }

    @Test(description = "Checking the value of goods. Choice of quantity,size and color of the goods from the Cart Test", priority = 1)
    public void checkingPropertiesProductFromCartTest() {
        homePage.clickMoreButton(PRODUCT_PRICE);
        productPage.clickPlusButton()
                .selectSize(SIZE)
                .clickColorButton(COLOR);
        String priceDisplay = productPage.getPriceDisplayProduct();
        String size = productPage.getSize(SIZE);
        String color = productPage.getAttributeColor(COLOR);
        productPage.clickAddToCartButton();
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assert.assertEquals(cartPage.getPriceProduct(PRODUCT_PRICE), priceDisplay);
        Assert.assertEquals(cartPage.getDescriptionProduct(PRODUCT_PRICE), "Color : " + color + ", Size : " + size);
        Assert.assertEquals(cartPage.getProductQuantityOnCartPage(PRODUCT_PRICE), QUANTITY);
    }
}
