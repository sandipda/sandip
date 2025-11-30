package stepDef;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.GUIElements;

public class TestGUIElements {

    private GUIElements guiElements;

    private GUIElements getGUIElements() {
        if (guiElements == null) {
            guiElements = new GUIElements(BaseClass.getDriver());
        }
        return guiElements;
    }

    @Given("Open the browser")
    public void openBrowser()
    {
        System.out.println("Browser: " + System.getProperty("browser", "chrome"));
    }
    @And("Run url as {string}")
    public void sendBrowserurl(String url){
        getGUIElements().openUrl(url);
        System.out.println("Navigated to URL: " + url);

    }

    @And("Click on Home page")
    public void clickOnHomePage() {
        getGUIElements().clickHomeLink();
    }

    @When("Check current url if matches {string}")
    public void checkCurrentUrlMatches(String expectedUrl) {
        String actualUrl = getGUIElements().getCurrentUrl();
        if (!expectedUrl.equals(actualUrl)) {
            throw new AssertionError("❌ URL mismatch! Expected: " + expectedUrl + ", Actual: " + actualUrl);
        }
    }

    @And("Check for the title {string}")
    public void checkForTheTitle(String expectedTitle) {
        String actualTitle = getGUIElements().getPageTitle();
        if (!expectedTitle.equals(actualTitle)) {
            throw new AssertionError("❌ Title mismatch! Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }
    }

    @And("Fill the form when pass string as {string} where {string} is {string}")
    public void fillTheFormWhenPassStringAs(String input, String locator, String value) {
        System.out.println("Filling the form with input: " + input);
        getGUIElements().fillform(input, locator, value);

    }

    @And("Choose radio button where {string} is {string}")
    public void chooseRadioButtonAsWhereIs(String locator, String value) {
        System.out.println("Selecting radio button with value");
        getGUIElements().clickRadioCheckButton(locator, value);
    }

    @And("Choose check-box where {string} is {string}")
    public void chooseCheckBoxAsWhereIs(String locator, String value) {
        System.out.println("Selecting checkbox with value");
        getGUIElements().clickRadioCheckButton(locator, value);
    }

    @And("Select string as {string} where {string} is {string}")
    public void selectStringAsWhereIs(String input, String locator, String value) {
        System.out.println("Selecting from dropdown: " + input);
        getGUIElements().selectDropdown(input, locator, value);
    }

    @And("Click on Submit button where {string} is {string}")
    public void clickOnSubmitButtonWhereIs(String locator, String value) {
        System.out.println("Clicking on Submit button");
        getGUIElements().submitbutton( locator, value);
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        System.out.println("Closing browser session");
    }
}
