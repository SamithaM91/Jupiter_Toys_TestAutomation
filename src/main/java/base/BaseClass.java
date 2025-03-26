package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void openPage(){

        String browser = "chrome";

        switch(browser.toLowerCase()) {
            case "chrome":
                 driver = new ChromeDriver();
                 break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser Not Supported " + browser);
                return;

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jupiter.cloud.planittesting.com/#/");
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
