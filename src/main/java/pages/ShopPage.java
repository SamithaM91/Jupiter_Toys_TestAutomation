package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By stuffedFrogBuyButton = By.xpath("//li[contains(.,'Stuffed Frog')]//a[contains(text(),'Buy')]");
    private final By fluffyBunnyBuyButton = By.xpath("//li[contains(.,'Fluffy Bunny')]//a[contains(text(),'Buy')]");
    private final By valentineBearBuyButton = By.xpath("//li[contains(.,'Valentine Bear')]//a[contains(text(),'Buy')]");
    private final By cartButton = By.id("nav-cart");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnShopPage() {
        return wait.until(ExpectedConditions.urlContains("/shop"));
    }

    private void buyItem(By itemLocator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            WebDriverWait waitForClickable = new WebDriverWait(driver, Duration.ofSeconds(10));
            waitForClickable.until(ExpectedConditions.elementToBeClickable(itemLocator));
            driver.findElement(itemLocator).click();
        }

    }

    public void buyStuffedFrog(int quantity) {
        buyItem(stuffedFrogBuyButton, quantity);
    }

    public void buyFluffyBunny(int quantity) {
        buyItem(fluffyBunnyBuyButton, quantity);
    }

    public void buyValentineBear(int quantity) {
        buyItem(valentineBearBuyButton, quantity);
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
