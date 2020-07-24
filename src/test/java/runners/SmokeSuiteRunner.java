package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"steps"},
        tags = {"@Smoke", "~@Ignore"}
//        dryRun = true // in case of generating code snippets for step_defs
)
public class SmokeSuiteRunner {


}
