package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

/**
 * This Class consists the below test case steps
 * 1. Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
 * 2. Go to the cart page
 * 3. Verify the subtotal for each product is correct
 * 4. Verify the price for each product
 * 5. Verify that total = sum(subtotal)
 */
public class ShoppingCartValidationTest extends BaseClass {

    @Test
    public void TC003() {
      //  Implement navigation from home page to shop page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToShopPage();

        //Initialize ShopPage object for interacting with the shop page
        ShopPage shopPage = new ShopPage(driver);
        //Validate user is on the shop page after navigation
        Assert.assertTrue(shopPage.isOnShopPage(), "User is NOT on the Shop page!");

        //Add items and navigate to the shopping cart
        shopPage.buyStuffedFrog(2);
        shopPage.buyFluffyBunny(5);
        shopPage.buyValentineBear(3);
        shopPage.goToCart();

        //Initialize ShopPage object for interacting with the shop page
        CartPage cartPage = new CartPage(driver);
        //Validate user is on the cart page after navigation
        Assert.assertTrue(cartPage.isOnCartPage(), "User is NOT on the Cart page!");
        //Validate cart details after adding items
        Assert.assertTrue(cartPage.verifyCartDetails(), "Cart validation failed!");
    }
}
