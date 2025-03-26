package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By cartTable = By.cssSelector("table.cart-items");
    private final By itemRows = By.cssSelector("table.cart-items tbody tr");
    private final By totalAmount = By.xpath("//strong[@class='total ng-binding']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnCartPage() {
        return wait.until(ExpectedConditions.urlContains("/cart"));
    }

    public class CartItem {
        private final WebElement row;

        public CartItem(WebElement row) {
            this.row = row;
        }

        public double getPrice() {
            return Double.parseDouble(row.findElement(By.cssSelector("td:nth-child(2)")).getText().replace("$", ""));
        }

        public int getQuantity() {
            return Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(3) input")).getAttribute("value"));
        }

        public double getSubtotal() {
            return Double.parseDouble(row.findElement(By.cssSelector("td:nth-child(4)")).getText().replace("$", ""));
        }

        public boolean verifySubtotal() {
            return getSubtotal() == (getPrice() * getQuantity());
        }
    }


    public boolean verifyCartDetails() {
        List<WebElement> rows = driver.findElements(itemRows);
        double calculatedTotal = 0.0;

        for (WebElement row : rows) {
            CartItem item = new CartItem(row);

            if (!item.verifySubtotal()) {
                return false;
            }
            calculatedTotal += item.getSubtotal();
        }

        return calculatedTotal == getDisplayedTotal();
    }

    public double getDisplayedTotal() {
        //return Double.parseDouble(driver.findElement(totalAmount).getText().replace("$", ""));
        return Double.parseDouble(driver.findElement(totalAmount).getText().replaceAll("[^0-9.]", ""));
    }





}
