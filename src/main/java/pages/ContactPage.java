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

    private final By submitButton = By.xpath("//a[normalize-space()='Submit']");
    private final By forenameField = By.id("forename");
    private final By emailField = By.id("email");
    private final By messageField = By.id("message");
    private final By errorMessages = By.cssSelector(".alert.alert-error.ng-scope");

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
        fillTextField(forenameField, forename);
        fillTextField(emailField, email);
        fillTextField(messageField, message);
    }

    private void fillTextField(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public boolean areErrorsGone() {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessages));
        } catch (Exception e) {
            System.out.println("Error while checking for errors: " + e.getMessage());
            return false;
        }
    }
}
