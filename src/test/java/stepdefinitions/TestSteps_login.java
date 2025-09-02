package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.junit.Assert;
import pageObjects.Negative_login;
import pageObjects.Positive_login;

public class TestSteps_login {

    private Positive_login loginPage;
    private Negative_login negative_loginPage;

    private Positive_login getLoginPage() {
        if (loginPage == null) {
            loginPage = new Positive_login(BaseClass.getDriver());
        }
        return loginPage;
    }

    private Negative_login getNegativeLoginPage() {
        if (negative_loginPage == null) {
            negative_loginPage = new Negative_login(BaseClass.getDriver());
        }
        return negative_loginPage;
    }

    @Given("Open the browser")
    public void open_the_browser() {
        Allure.step("Browser: " + System.getProperty("browser", "chrome"));
    }

    @Given("pass url as {string}")
    public void pass_url_as(String urlString) {
        getLoginPage().openPage(urlString);
        Allure.step("Navigated to URL: " + urlString);
    }

    @When("Check current url")
    public void check_current_url() {
        Allure.step("Current URL is: " + getLoginPage().getCurrentUrl());
    }

    @Then("get the page description")
    public void get_the_page_description() {
        String desc = getLoginPage().getPageDescription();
        Assert.assertFalse("❌ Page description is empty!", desc.isEmpty());
        Allure.step("Page description OK");
    }

    @Then("Get page title if matches {string}")
    public void get_page_title_if_matches(String expectedTitle) {
        Assert.assertEquals("❌ Title mismatch!", expectedTitle, getLoginPage().getTitle());
    }

    @Then("check if button is clickable or not and get button text")
    public void check_if_button_is_clickable_or_not_and_get_button_text() {
        Assert.assertTrue("❌ Login button not clickable!", getLoginPage().isButtonClickable());
    }

    @Then("pass username {string}")
    public void pass_username(String username) {
        getLoginPage().enterUsername(username);
    }

    @Then("pass password {string}")
    public void pass_password(String password) {
        getLoginPage().enterPassword(password);
    }

    @When("Click on Submit button")
    public void click_on_submit_button() {
        getLoginPage().explicitWait("//*[@id='submit']", 10);
        getLoginPage().clickLogin();
    }

    @And("Check if error displayed")
    public void check_if_error_displayed() {
        Assert.assertTrue("❌ Error not displayed!", getNegativeLoginPage().errorDisplayed());
    }

    @And("Verify if error message text matches {string}")
    public void verify_if_error_message_text_matches(String errorMsg) {
        Assert.assertEquals("❌ Error message mismatch!", errorMsg, getNegativeLoginPage().getErrorTitle());
    }
}
