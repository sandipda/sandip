package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.Positive_login;

import java.io.ByteArrayInputStream;

public class TestSteps_approach_2 extends BaseClass {
    private Positive_login loginPage;

    @Given("Open the browser {string}")
    public void open_the_browser(String browser) {
        driver = BaseClass.initializeBrowser(browser);
        loginPage = new Positive_login(driver);
    }

    @Given("pass url as {string}")
    public void pass_url_as(String urlString) {
        loginPage.openPage(urlString);
    }

    @When("Check current url")
    public void check_current_url() {
        String currentUrl = loginPage.getCurrentUrl();
        System.out.println("✅ Current URL: " + currentUrl);
    }

    @Then("get the page description")
    public void get_the_page_description() {
        String desc = loginPage.getPageDescription();
        System.out.println("✅ Page Description: " + desc);
        Assert.assertFalse("❌ Page description is empty!", desc.isEmpty());
    }

    @Then("Get page title if matches {string}")
    public void get_page_title_if_matches(String expectedTitle) {
        String actualTitle = loginPage.getTitle();
        Assert.assertEquals("❌ Title mismatch!", expectedTitle, actualTitle);
    }

    @Then("check if button is clickable or not and get button text")
    public void check_if_button_is_clickable_or_not_and_get_button_text() {
        boolean clickable = loginPage.isButtonClickable();
        Assert.assertTrue("❌ Login button not clickable!", clickable);
        System.out.println("✅ Login button is clickable");
    }

    @Then("pass username {string}")
    public void pass_username(String username) {
        loginPage.enterUsername(username);
    }

    @Then("pass password {string}")
    public void pass_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("Click on Submit button")
    public void click_on_submit_button() {
        loginPage.explicitWait("//*[@id='submit']", 10);
        loginPage.clickLogin();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
            Thread.sleep(9000);
        }
        BaseClass.quitBrowser();
    }
}
