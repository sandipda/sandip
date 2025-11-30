package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GUIElements {

    public WebDriver driver;

    public GUIElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"PageList2\"]/div/ul/li[1]/a")
    WebElement homelink;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    WebElement pageTitle;

    @FindBy(id = "name")
    WebElement nameInput;

    public void openUrl(String url){
        try{
            driver.get(url);
        } catch (Exception e) {
            driver.navigate().to(url);
            throw new RuntimeException(e);
        }
    }
    public void clickHomeLink(){
        homelink.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return pageTitle.getText().toString();
    }

    public void fillform(String input, String locator, String value){
        try{
            Thread.sleep(2000);
            switch (locator.toLowerCase()){
                case "xpath":
                    WebElement Xpath = driver.findElement(By.xpath(value));
                    Xpath.sendKeys(input);
                    break;
                case "cssselector":
                    WebElement css = driver.findElement(By.cssSelector(value));
                    css.sendKeys(input);
                    break;
                case "linktext":
                    WebElement link = driver.findElement(By.linkText(value));
                    link.sendKeys(input);
                    break;
                case "classname":
                    WebElement className = driver.findElement(By.className(value));
                    className.sendKeys(input);
                    break;
                case "id":
                    WebElement id = driver.findElement(By.id(value));
                    id.sendKeys(input);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locator);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void submitbutton(String locator, String value){
        try{
            Thread.sleep(2000);
            switch (locator.toLowerCase()){
                case "xpath":
                    WebElement Xpath = driver.findElement(By.xpath(value));
                    Xpath.click();
                    break;
                case "cssselector":
                    WebElement css = driver.findElement(By.cssSelector(value));
                    css.click();
                    break;
                case "linktext":
                    WebElement link = driver.findElement(By.linkText(value));
                    link.click();
                    break;
                case "classname":
                    WebElement className = driver.findElement(By.className(value));
                    className.click();
                    break;
                case "id":
                    WebElement id = driver.findElement(By.id(value));
                    id.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locator);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickRadioCheckButton(String locator, String value){
        try{
            Thread.sleep(2000);
            switch (locator.toLowerCase()){
                case "xpath":
                    WebElement Xpath = driver.findElement(By.xpath(value));
                    Actions action1 = new Actions(driver);
                    action1.moveToElement(Xpath).click().build().perform();
                    break;
                case "cssselector":
                    WebElement css = driver.findElement(By.cssSelector(value));
                    Actions action2 = new Actions(driver);
                    action2.moveToElement(css).click().build().perform();
                    break;
                case "linktext":
                    WebElement link = driver.findElement(By.linkText(value));
                    Actions action3 = new Actions(driver);
                    action3.moveToElement(link).click().build().perform();
                    break;
                case "classname":
                    WebElement className = driver.findElement(By.className(value));
                    Actions action4 = new Actions(driver);
                    action4.moveToElement(className).click().build().perform();
                    break;
                case "id":
                    WebElement id = driver.findElement(By.id(value));
                    Actions action5 = new Actions(driver);
                    action5.moveToElement(id).click().build().perform();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locator);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectDropdown(String input, String locator, String value){
        try{
            Object object = input;
            Thread.sleep(2000);
            switch (locator.toLowerCase()){
                case "xpath":
                    WebElement Xpath = driver.findElement(By.xpath(value));
                    Actions action1 = new Actions(driver);
                    action1.moveToElement(Xpath).click().build().perform();
                    Select dropdown1 = new Select(Xpath);

                    if(object instanceof String){
                        dropdown1.selectByVisibleText(input);
                    } else if (object instanceof Integer) {
                        dropdown1.selectByIndex(Integer.parseInt(input));
                    }
                    break;
                case "cssselector":
                    WebElement css = driver.findElement(By.cssSelector(value));
                    Actions action2 = new Actions(driver);
                    action2.moveToElement(css).click().build().perform();
                    Select dropdown2 = new Select(css);

                    if(object instanceof String){
                        dropdown2.selectByVisibleText(input);
                    } else if (object instanceof Integer) {
                        dropdown2.selectByIndex(Integer.parseInt(input));
                    }
                    break;
                case "linktext":
                    WebElement link = driver.findElement(By.linkText(value));
                    Actions action3 = new Actions(driver);
                    action3.moveToElement(link).click().build().perform();
                    Select dropdown3 = new Select(link);

                    if(object instanceof String){
                        dropdown3.selectByVisibleText(input);
                    } else if (object instanceof Integer) {
                        dropdown3.selectByIndex(Integer.parseInt(input));
                    }
                    break;
                case "classname":
                    WebElement className = driver.findElement(By.className(value));
                    Actions action4 = new Actions(driver);
                    action4.moveToElement(className).click().build().perform();
                    Select dropdown4 = new Select(className);

                    if(object instanceof String){
                        dropdown4.selectByVisibleText(input);
                    } else if (object instanceof Integer) {
                        dropdown4.selectByIndex(Integer.parseInt(input));
                    }
                    break;
                case "id":
                    WebElement id = driver.findElement(By.id(value));
                    Actions action5 = new Actions(driver);
                    action5.moveToElement(id).click().build().perform();
                    Select dropdown5 = new Select(id);

                    if(object instanceof String){
                        dropdown5.selectByVisibleText(input);
                    } else if (object instanceof Integer) {
                        dropdown5.selectByIndex(Integer.parseInt(input));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + locator);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
