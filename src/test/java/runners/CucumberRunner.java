package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * //TODO:
 * Implement a Junit Test Runner class.
 * This class just needs annotations to understand that cucumber features would be run through it
 * and you can specify feature files to be picked up plus the steps package location.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"}
)
public class CucumberRunner {
}
