package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.Account;
import domains.BankAccount;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;

import java.util.LinkedList;
import java.util.List;

public class DigitalBankBankingAccountsSteps extends Hooks{
    String checkingMenuCSS = ".dropdown-toggle";
    String newCheckingAccountPageHeaderCSS = ".card-header";
    String newCheckingAccountLinkText = "New Checking";
    String accountTypeButtonsID = "Checking";
    String nameFieldID = "name";
    String openingBalanceFieldID = "openingBalance";
    String submitButtonCSS = ".btn-primary.btn-sm";
    Account bankAccount;
    WebElement currAcc;


    @When("^User navigates to new Checking account page$")
    public void userNavigatesToNewCheckingAccountPage() {
        Driver.getDriver().findElement(By.cssSelector(checkingMenuCSS)).click();
        Driver.getDriver().findElement(By.linkText("New Checking")).click();
        Assert.assertTrue(
                Driver.waitFor(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(newCheckingAccountPageHeaderCSS)))
                .getText().trim().toLowerCase()
                .equals("new checking account")
        );
    }

    @And("^User creates checking account with following fields$")
    public void userCreatesCheckingAccountWithFollowingFields(DataTable table) {
        bankAccount = table.asList(Account.class).get(0);

        Driver.getDriver()
                .findElement(By.id(bankAccount.getType() + " " + accountTypeButtonsID))
                .click();

        Driver.getDriver()
                .findElement(By.id(bankAccount.getOwnershipType()))
                .click();

        Driver.getDriver()
                .findElement(By.id(nameFieldID))
                .sendKeys(bankAccount.getAccountName());

        Driver.getDriver()
                .findElement(By.id(openingBalanceFieldID))
                .sendKeys(String.valueOf(bankAccount.getInitDeposit()));

        Driver.getDriver()
                .findElement(By.cssSelector(submitButtonCSS))
                .click();
    }

    @Then("^User should be able to see a new account created$")
    public void userShouldBeAbleToSeeANewAccountCreated() {
        List<WebElement> ls = Driver.getDriver().findElements(By.cssSelector(""));
        for(WebElement el : ls){
            if(el.findElement(By.cssSelector("")).getText().equals(bankAccount.getAccountName())){
                currAcc = el;
                return;
            }
        }
        Assert.fail();
    }

    @And("^Account information is matching$")
    public void accountInformationIsMatching() {

    }
}
