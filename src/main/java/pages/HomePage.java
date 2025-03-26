package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    final By contactLink = By.linkText("Contact");
    final By shopLink = By.linkText("Shop");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToContactPage() {
        driver.findElement(contactLink).click();
    }

    public void navigateToShopPage() {
        driver.findElement(shopLink).click();
    }
}
