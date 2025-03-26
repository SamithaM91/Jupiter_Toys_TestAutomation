package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ContactPage {

    WebDriver driver;
    WebDriverWait wait;

    final By submitButton = By.xpath("//a[normalize-space()='Submit']");
    final By forenameField = By.id("forename");
    final By emailField = By.id("email");
    final By messageField = By.id("message");
    final By errorMessages = By.cssSelector(".alert.alert-error.ng-scope");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnContactPage() {
        return wait.until(ExpectedConditions.urlContains("/contact"));
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public List<WebElement> getErrorMessages() {
        return driver.findElements(errorMessages);
    }


    public boolean areErrorsDisplayed() {
        return !getErrorMessages().isEmpty();
    }


    public void fillMandatoryFields(String forename, String email, String message) {
        driver.findElement(forenameField).sendKeys(forename);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public boolean areErrorsGone() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessages));
    }
}
