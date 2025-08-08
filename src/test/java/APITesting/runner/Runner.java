package APITesting.runner;

import org.junit.runner.RunWith;

// import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/APITesting/scenario", 
    monochrome = true,                          
    glue = "APITesting.stepsOfDefinitions",
    plugin = {"pretty",                                   // Pretty console output
                "html:target/cucumber-report.html",          // HTML report
                "json:target/cucumber-report.json",          // JSON report
                "junit:target/cucumber-report.xml"           // JUnit XML report
            }
)

public class Runner {
}