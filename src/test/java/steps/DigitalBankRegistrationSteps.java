package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.MockData;
import domains.User;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * TODO:
 * Add implementations of steps from feature file
 */
public class DigitalBankRegistrationSteps {
    private WebDriver driver;
    private final String LOGIN_PAGE_URL = "http://dbankdemo.com/login";
    private final String HOME_PAGE_URL = "http://dbankdemo.com/home";
    private final String SIGNUP_PAGE_URL = "http://dbankdemo.com/signup";

    @Given("^User navigates to Digital Bank login page$")
    public void user_navigates_to_Digital_Bank_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    driver = Driver.getDriver();
    driver.get(LOGIN_PAGE_URL);
    assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());

    }

    @Given("^Verify that web title is \"([^\"]*)\"$")
    public void verify_that_web_title_is(String expectedTitle) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedTitle, driver.getTitle());

    }

    @When("^User logs in with following credentials$")
    public void user_logs_in_with_following_credentials(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)


    }

    @Then("^User successfully logged in to home page$")
    public void user_successfully_logged_in_to_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^User logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logs_in_with_and(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^User should be displayed with the error message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_error_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^User navigates to Digital Bank signup page$")
    public void user_navigates_to_Digital_Bank_signup_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^User creates account with following fields$")
    public void user_creates_account_with_following_fields(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)

    }

    @Then("^User should be displayed with the message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

}

