package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver initializeBrowser(String browser) {
        if (browser == null) {
            browser = "chrome"; // default
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\automationDemo\\Driver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Hp\\automationDemo\\Driver\\msedgedriver.exe");
                EdgeOptions option = new EdgeOptions();
                option.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(option);
                break;
            default:
                throw new IllegalArgumentException("❌ Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver; // IMPORTANT: return driver so hooks/steps can use it
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
