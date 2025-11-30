package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // required import io.cucumber.junit.Cucumber; as MANDATORY
@CucumberOptions(
        features = "features//test_GUI_Elements.feature",
        glue = {"stepDef", "hooks"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner {


}
