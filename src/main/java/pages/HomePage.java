package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    private final By contactLink = By.linkText("Contact");
    private final By shopLink = By.linkText("Shop");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void navigateToContactPage() {
        clickLink(contactLink);
    }

    public void navigateToShopPage() {
        clickLink(shopLink);
    }
}
