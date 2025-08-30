package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass {
    public static WebDriver driver;

    public static WebDriver initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "F:\\automationDemo\\Driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "F:\\automationDemo\\Driver\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
