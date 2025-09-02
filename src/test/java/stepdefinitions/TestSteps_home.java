package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.Home_page;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestSteps_home {

    private Home_page homepage;

    private Home_page getHomePage() {
        if (homepage == null) {
            homepage = new Home_page(BaseClass.getDriver());
        }
        return homepage;
    }

    @And("Click on Home page")
    public void click_on_home_page() {
        getHomePage().clickHome();
    }

    @And("Check for all broken links and list down all links if broken")
    public void check_broken_links_on_home_page() {
        getHomePage().checkBroken_links();
    }

    @Then("List down all links are visible in home page")
    public void list_down_all_links() {
        getHomePage().list_down_allLink();
    }

    @When("Check current url if matches {string}")
    public void check_current_url_matches(String expectedUrl) {
        String actualUrl = getHomePage().currentTitle();
        Assert.assertEquals("❌ URL mismatch!", expectedUrl, actualUrl);
    }

    @Then("get the page description and store in text file {string}")
    public void get_page_description_and_store(String pathOrDir) {
        String desc = getHomePage().get_home_description();

        File f = new File(pathOrDir);
        File out = f.isDirectory() ? new File(f, "page-description.txt") : f;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            writer.write(desc);
            System.out.println("✅ Wrote description to: " + out.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed writing page description", e);
        }
    }

    @Then("get newsletter title")
    public void get_newsletter_title() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        getHomePage().get_news_title();
    }

    @Then("Put name as {string} in newsletter")
    public void put_name_as_newsletter(String name) {
        getHomePage().set_news_text_name(name);
    }

    @Then("Put email as {string} in newsletter")
    public void put_email_as_newsletter(String email) {
        getHomePage().set_news_text_email(email);
    }

    @And("Click on button and check for the title {string}")
    public void click_button(String expectedButtonTitle) {
        getHomePage().click_news_button();
        Assert.assertEquals("❌ Button title mismatch!", expectedButtonTitle, getHomePage().get_news_button_title());
    }
}
