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

    //Price parsing method with error handling for invalid formats
    private double parsePrice(String price) {
        try {
            return Double.parseDouble(price.replace("$", "").trim());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing price: " + price);
            return 0.0;
        }
    }

    //Method to verify user is on the cart page by checking URL
    public boolean isOnCartPage() {
        return wait.until(ExpectedConditions.urlContains("/cart"));
    }

    // CartItem class to encapsulate price, quantity, and subtotal verification
    public class CartItem {
        private final WebElement row;

        public CartItem(WebElement row) {
            this.row = row;
        }

        //Retrieve and parse item price from the cart row
        public double getPrice() {
            return parsePrice(row.findElement(By.cssSelector("td:nth-child(2)")).getText());
        }

        //Retrieve and parse item quantity from the cart row
        public int getQuantity() {
            return Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(3) input")).getAttribute("value"));
        }

        //Retrieve and parse item subtotal from the cart row
        public double getSubtotal() {
            return parsePrice(row.findElement(By.cssSelector("td:nth-child(4)")).getText());
        }

        //Verify item subtotal is correctly calculated based on price and quantity
        public boolean verifySubtotal() {
            return getSubtotal() == (getPrice() * getQuantity());
        }
    }

    //Cart details verification by validating item subtotals and total price
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

    //Extract and parse displayed total amount from the cart summary
    public double getDisplayedTotal() {
        return parsePrice(driver.findElement(totalAmount).getText().replaceAll("[^0-9.]", ""));
    }





}
