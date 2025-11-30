package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver initiatebrowser(String browser){
        if(browser == null){
            browser = "chrome";
        }

        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("WebDriver.chrome.driver","C:\\Users\\USER\\IdeaProjects\\git-scratch-project\\Driver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":

                break;
            case "edge":

                break;
            default:
                throw new IllegalArgumentException("❌ Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;

    }

    public static void quitbrowser(){
        if(driver!=null){
//            driver.quit();
        }
    }
}
