package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Home_page {

    public WebDriver driver;

    public Home_page(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//li[@id='menu-item-43']//child::a")
    WebElement header_home;

    @FindBy(xpath = "//div[@class='post-content']")
    WebElement home_description;

    @FindBy(xpath = "//h6[contains(@class,'mailpoet-heading')]")
    WebElement news_title;

    @FindBy(xpath = "//input[@class='mailpoet_text' and @type='text']")
    WebElement news_text_name;

    @FindBy(xpath = "//input[@class='mailpoet_text' and @type='email']")
    WebElement news_text_email;

    @FindBy(xpath = "//input[@class='mailpoet_submit' and @type='submit']")
    WebElement news_button;

    public void clickHome()
    {
        header_home.click();
    }

    public String currentTitle(){
        return driver.getCurrentUrl();
    }

    public String get_home_description()
    {
        return home_description.getText();
    }

    public String get_news_title()
    {
        return news_title.getText();
    }

    public void set_news_text_name(String name)
    {
        news_text_name.sendKeys(name);
    }

    public void set_news_text_email(String email)
    {
        news_text_email.sendKeys(email);
    }

    public void click_news_button()
    {
        news_button.click();
    }

    public String get_news_button_title()
    {
        return news_button.getText();
    }

    public void checkBroken_links()
    {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Link has no href attribute: " + link.getText());
                continue;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                httpURLConnection.setConnectTimeout(5000); // 5 seconds timeout
                httpURLConnection.connect();

                int responseCode = httpURLConnection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("BROKEN LINK: " + url + " - Response Code: " + responseCode);
                } else {
                    System.out.println("VALID LINK: " + url + " - Response Code: " + responseCode);
                }
            } catch (MalformedURLException e) {
                System.out.println("INVALID URL FORMAT: " + url + " - " + e.getMessage());
            } catch (IOException e) {
                System.out.println("ERROR CONNECTING TO LINK: " + url + " - " + e.getMessage());
            }
        }
    }

    public void list_down_allLink(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement link : links)
        {
            System.out.println("Link has no href attribute: " + link.getText());
        }
    }
}
