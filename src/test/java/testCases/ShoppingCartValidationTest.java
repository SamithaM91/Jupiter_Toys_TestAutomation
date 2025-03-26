package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

public class ShoppingCartValidationTest extends BaseClass {

    @Test
    public void TC003() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToShopPage();

        ShopPage shopPage = new ShopPage(driver);
        Assert.assertTrue(shopPage.isOnShopPage(), "User is NOT on the Shop page!");

        shopPage.buyStuffedFrog(2);
        shopPage.buyFluffyBunny(5);
        shopPage.buyValentineBear(3);
        shopPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isOnCartPage(), "User is NOT on the Cart page!");

        Assert.assertTrue(cartPage.verifyCartDetails(), "Cart validation failed!");
    }
}
