package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//Features/login.feature",
        glue = "stepdefinitions",
        dryRun = false, // it checks if all steps has corresponding methods created, and it always accepts false as default
        monochrome = true, // it checks if console has any anonymous character printed or not so it will remove the same
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner {

}

//run this below in terminal to run allure report
// npm install -g allure-commandline --save -dev

// To-generate report pass report
// allure generate  allure-results --clean -o allure-report