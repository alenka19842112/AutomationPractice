package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "add product to Cart Test", priority = 1)
    public void addProductToCartTest() {
        homePage.clickAddProductButton(PRODUCT_NUMBER);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.isProductInCart(PRODUCT_NUMBER));
    }

    @Test(description = "delete product from the Cart Test", priority = 1)
    public void deleteProductFromCartTest() {
        homePage.clickAddProductButton(PRODUCT_NUMBER);
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        cartPage.deleteProductFromCart(PRODUCT_NUMBER);
        Assert.assertTrue(cartPage.isProductDeletedFromCart(PRODUCT_NUMBER));
    }

    @Test(description = "Checking the value of goods. Choice of quantity,size and color of the goods from the Cart Test", priority = 1)
    public void checkingPropertiesProductFromCartTest() {
        homePage.clickMoreButton(PRODUCT_NUMBER);
        productPage.clickPlusButton()
                .selectSize(SIZE)
                .clickColorButton(COLOR);
        String priceDisplay = productPage.getPriceDisplayProduct();
        String size = productPage.getSize(SIZE);
        String color = productPage.getAttributeColor(COLOR);
        productPage.clickAddToCartButton();
        productAddedToCartModalPage.clickProceedToCheckoutButton();
        Assert.assertEquals(cartPage.getPriceProduct(PRODUCT_NUMBER), priceDisplay);
        Assert.assertEquals(cartPage.getDescriptionProduct(PRODUCT_NUMBER), "Color : " + color + ", Size : " + size);
        Assert.assertEquals(cartPage.getProductQuantityOnCartPage(PRODUCT_NUMBER), QUANTITY);
    }
}
