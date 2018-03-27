package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/Features/contact.feature",
        glue={"Steps"},
        plugin = {"pretty", "html:target/cucumber-html-report"} // generating html report in project folder
    // ,monochrome = true
)

public class TestRunner {


}
