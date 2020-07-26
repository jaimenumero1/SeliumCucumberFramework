package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
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
  WebDriver driver;
  String LOGIN_PAGE_URL;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(LOGIN_PAGE_URL);
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Given("^User navigates to Digital Bank login page$")
    public void user_navigates_to_Digital_Bank_login_page() {

    }

    @Given("^Verify that web title is \"([^\"]*)\"$")
    public void verify_that_web_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("^User logs in with following credentials$")
    public void user_logs_in_with_following_credentials(DataTable arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        System.out.println(arg1);
    }

    @Then("^User successfully logged in to home page$")
    public void user_successfully_logged_in_to_home_page() {

    }

    @When("^User logs in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logs_in_with_and(String user, String pass) throws InterruptedException {
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        userName.sendKeys(user);
        password.sendKeys(pass);
        driver.findElement(By.id("submit")).click();



    }

    @Then("^User should be displayed with the error message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_error_message(String arg1) {
        Assert.assertTrue("Error message",driver.findElement(By.xpath("//span[@class='badge badge-pill badge-danger']")).isDisplayed());
    }

    @Given("^User navigates to Digital Bank signup page$")
    public void user_navigates_to_Digital_Bank_signup_page() {
        Driver.getDriver().get("http://dbankdemo.com/signup");
    }

    @When("^User creates account with following fields$")
    public void user_creates_account_with_following_fields(DataTable table) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        User user = table.asList(User.class).get(0);

        Driver.getDriver().findElement(By.xpath("//select[@id='title']")).click();
        Driver.getDriver().findElement(By.xpath("//option[text()='Mr.']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(user.getFirstName());
        Driver.getDriver().findElement(By.id("lastName")).sendKeys(user.getLastName());
        Driver.getDriver().findElement(By.xpath("//input[@id='gender'][1]")).click();
        Driver.getDriver().findElement(By.id("dob")).sendKeys(user.getDob());
        Driver.getDriver().findElement(By.id("ssn")).sendKeys(user.getSsn());
        Driver.getDriver().findElement(By.id("emailAddress")).sendKeys(user.getEmailAddress());
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(user.getPassword());
        Driver.getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(user.getPassword());
        Driver.getDriver().findElement(By.xpath("//button[text()='Next']")).click();

    }

    @Then("^User should be displayed with the message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_message(String arg1) {

    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }


}

