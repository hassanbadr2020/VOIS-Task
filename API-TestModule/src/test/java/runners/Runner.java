package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = true,
         plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:testOutput/HtmlReport/ExtentHtml.html"},
//        plugin={"pretty", "html:build/test-results/test-report"},
        features = {"src/test/resources/featureFiles"},
        glue = {"stepDefinitions"}
)

public class Runner {

}
