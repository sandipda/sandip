package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Negative_login {
    public WebDriver driver;
    public Negative_login(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='error' and @class='show']")
    WebElement errorDis;

    public boolean errorDisplayed()
    {
        return errorDis.isDisplayed();
    }

    public String getErrorTitle(){

        return errorDis.getText();
    }
}
