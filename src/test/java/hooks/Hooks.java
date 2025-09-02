package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        BaseClass.initializeBrowser(browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && BaseClass.getDriver() != null) {
            byte[] shot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(shot));
        }
        BaseClass.quitBrowser();
    }
}
