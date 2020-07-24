package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Create a runner class
 */
@RunWith(Cucumber.class)
@CucumberOptions(

		plugin= {"pretty", "html:target/cucumber-report",
			"json:target/cucumber.json"},

	    features = {"src/test/resources"},
	    glue = {"steps"},

		tags = {"@SavingsUserStories10"},
		dryRun = false


		)

public class CucumberRunner {
}
