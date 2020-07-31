package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;

public class DigitalBankBankingAccountsSteps {
    String checkingMenuCSS = ".dropdown-toggle";
    String newCheckingAccountPageHeaderCSS = ".card-header";

    @When("^User navigates to new Checking account page$")
    public void userNavigatesToNewCheckingAccountPage() {
        Driver.getDriver().findElement(By.cssSelector(checkingMenuCSS)).click();
        Assert.assertTrue(
                Driver.waitFor(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(newCheckingAccountPageHeaderCSS)))
                .getText().trim().toLowerCase()
                .equals("new checking account")
        );
    }

    @And("^User creates checking account with following fields$")
    public void userCreatesCheckingAccountWithFollowingFields() {
    }

    @Then("^User should be able to see a new account created$")
    public void userShouldBeAbleToSeeANewAccountCreated() {
    }

    @And("^Account information is matching$")
    public void accountInformationIsMatching() {
    }
}
