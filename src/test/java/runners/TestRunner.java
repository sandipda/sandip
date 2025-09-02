package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // <-- your features are in projectRoot/features
        features = "features//login.feature",
        glue = {"stepdefinitions", "hooks"},   // your steps + Hooks package
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



//run this below in terminal to run allure report
// npm install -g allure-commandline --save -dev

// To-generate report pass report
// allure generate  allure-results --clean -o allure-report