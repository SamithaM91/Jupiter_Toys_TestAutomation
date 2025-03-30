package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void openPage(){

        // Load the URL from the config file
        loadConfig();

        String browser = "chrome"; //define the testing browser

        switch(browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // // Run Chrome in headless mode
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless"); // Run Firefox in headless mode
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless"); // Run Edge in headless mode
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                System.out.println("Browser Not Supported " + browser);
                return;

        }
        //Maximize the web page, Set implicit wait and navigate to the homepage URL
        driver.manage().window().maximize(); // This might not be required for the CI environments
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    // Configuration from the config.properties file
    private void loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
            baseUrl = properties.getProperty("baseUrl");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
