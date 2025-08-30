package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Positive_login {
    private WebDriver driver;

    public Positive_login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Test login']")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id='login']/ul/li[1]")
    private WebElement pageDescription;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement passWord;

    @FindBy(id = "submit")
    private WebElement button;

    // Utility methods
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public void implicitWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public void explicitWait(String xpath, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    // Page actions
    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public String getPageDescription() {
        return pageDescription.getText();
    }

    public void enterUsername(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        passWord.sendKeys(password);
    }

    public void assertTitle(String title)
    {
        String ActualTitle = pageTitle.getText();
        String ExpectedTitle = title;//"Test login"; Assert.assertEquals(ExpectedTitle,ActualTitle,"Titile is not a match");
    }

    public boolean isButtonClickable() {
        return button.isDisplayed() && button.isEnabled();
    }

    public void clickLogin() {
        button.click();
    }
}
