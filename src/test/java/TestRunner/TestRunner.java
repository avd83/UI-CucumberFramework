package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features"},
		glue = {"stepDefinitions"},
		plugin= {"pretty","html:test-output"},
		tags = "@Regression",
		dryRun=false,
		monochrome=false,
		publish = true		
		)

public class TestRunner {

}
