package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserHelper;
import utilities.Driver;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class DigitalBankBankingAccountsSteps {

    private final WebDriver driver = Driver.getDriver();
    private List<Map<String, String>> accountInfo;

    @And("^Verify that \"([^\"]*)\" welcoming message is displayed$")
    public void verifyThatWelcomingMessageIsDisplayed(String arg0) throws Throwable {
        BrowserHelper.waitForPageLoadComplete(driver, 30);
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'" + arg0 + "')]")).isDisplayed());
    }

    @And("^Verify that panel with account information is displayed$")
    public void verifyThatPanelWithAccountInformationIsDisplayed() {
        WebElement home = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(home.isDisplayed());

        WebElement checking = driver.findElement(By.linkText("Checking"));
        Assert.assertTrue(checking.isDisplayed());

        WebElement savings = driver.findElement(By.linkText("Savings"));
        Assert.assertTrue(savings.isDisplayed());

        WebElement transactions = driver.findElement(By.linkText("Transactions"));
        Assert.assertTrue(transactions.isDisplayed());

        WebElement digitalCredit = driver.findElement(By.linkText("Digital Credit"));
        Assert.assertTrue(digitalCredit.isDisplayed());

        WebElement transfer = driver.findElement(By.linkText("Transfer"));
        Assert.assertTrue(transfer.isDisplayed());

        WebElement visaDirect = driver.findElement(By.linkText("VISA Direct"));
        Assert.assertTrue(visaDirect.isDisplayed());

    }



    @When("^User clicks on \"([^\"]*)\" account$")
    public void userClicksOnAccount(String type) {

        WebElement element = driver.findElement(By.linkText(type));
        element.click();
        element = driver.findElement(By.linkText("New "+type));
        element.click();
    }

    @Then("^Verify that \"([^\"]*)\" dropdown has following options$")
    public void verify_that_dropdown_has_following_options(String dropdown, DataTable options) throws Throwable {
        WebElement checking = driver.findElement(By.linkText(dropdown));
        Assert.assertTrue(checking.isDisplayed());
        List<String> list = options.asList(String.class);
        checking.click();
        List<WebElement> accountOptions = driver.findElements(By.xpath("//a[text()='" + dropdown + "']/..//ul//a"));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), accountOptions.get(i).getText().trim());
        }


    }

    @Then("^Verify \"([^\"]*)\" header is displayed$")
    public void verifyHeaderIsDisplayed(String arg0) throws Throwable {
        WebElement header = driver.findElement(By.xpath("//strong[starts-with(@class,'card-title')]"));
        Assert.assertEquals(arg0, header.getText().trim());
    }

    @And("^Verify \"([^\"]*)\" label is displayed$")
    public void verifyLabelIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//strong[text()='" + arg0 + "']")).isDisplayed());
    }

    @And("^Verify that radio buttons are unchecked$")
    public void verifyThatRadioButtonsAreUnchecked() {
        List<WebElement> radioBtnList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement el : radioBtnList) {
            Assert.assertFalse(el.isSelected());
        }
    }

    @And("^Verify that \"([^\"]*)\" button is displayed$")
    public void verifyThatButtonIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'" + arg0 + "')]")).isDisplayed());
    }

    @When("^User submits an account without Account Type$")
    public void userSubmitsAnAccountWithoutAccountType() {
        WebElement accountOwnership = driver.findElement(By.id("Individual"));
        accountOwnership.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys("Test Account");
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys("200");
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();


    }

    @Then("^Verify field error message \"([^\"]*)\" is displayed$")
    public void verifyFieldErrorMessageIsDisplayed(String arg0) throws Throwable {

        Assert.assertEquals(arg0, driver.switchTo().activeElement().getAttribute("validationMessage"));

    }

    @When("^User submits an account without Account Ownership$")
    public void userSubmitsAnAccountWithoutAccountOwnership() {

        WebElement accountType = driver.findElement(By.xpath("(//input[@name='accountType'])[2]"));
        accountType.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys("Test Account");
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys("200");
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();
    }

    @When("^User submits an account without Account Name$")
    public void userSubmitsAnAccountWithoutAccountName() {
        WebElement accountOwnership = driver.findElement(By.id("Individual"));
        accountOwnership.click();
        WebElement accountType = driver.findElement(By.xpath("(//input[@name='accountType'])[2]"));
        accountType.click();
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys("200");
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();
    }

    @When("^User submits an account without Initial Deposit Amount$")
    public void userSubmitsAnAccountWithoutInitialDepositAmount() {
        WebElement accountOwnership = driver.findElement(By.id("Individual"));
        accountOwnership.click();
        WebElement accountType = driver.findElement(By.xpath("(//input[@name='accountType'])[2]"));
        accountType.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys("Test Account");
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();
    }

    @When("^User submits an account with \"([^\"]*)\" deposit$")
    public void userSubmitsAnAccountWithDeposit(String depositAmount) throws Throwable {
        WebElement accountOwnership = driver.findElement(By.id("Individual"));
        accountOwnership.click();
        WebElement accountType = driver.findElement(By.xpath("(//input[@name='accountType'])[2]"));
        accountType.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys("Test Account");
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys(depositAmount);
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();
    }

    @Then("^Verify alert error message \"([^\"]*)\" is displayed$")
    public void verifyAlertErrorMessageIsDisplayed(String arg0) throws Throwable {
        WebElement error = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//span[2]"));
        Assert.assertEquals(arg0, error.getText());
    }


    @When("^User creates \"([^\"]*)\" account with following info:$")
    public void user_creates_account_with_following_info(String arg1, DataTable dataTable) throws Throwable {
        accountInfo = dataTable.asMaps(String.class, String.class);

        WebElement accountOwnership = driver.findElement(By.id(accountInfo.get(0).get("accountType")));
        accountOwnership.click();
        WebElement accountType = driver.findElement(By.id(accountInfo.get(0).get("accountOwnership")));
        accountType.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys(accountInfo.get(0).get("accountName"));
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys(accountInfo.get(0).get("initialDeposit"));
        WebElement submit = driver.findElement(By.cssSelector("[class='btn btn-primary btn-sm']"));
        submit.click();


    }

    @When("^User creates \"([^\"]*)\" account with following info and click Reset button$")
    public void user_creates_account_with_following_info_and_click_reset_button(String arg1, DataTable dataTable) throws Throwable {
        accountInfo = dataTable.asMaps(String.class, String.class);

        WebElement accountOwnership = driver.findElement(By.id(accountInfo.get(0).get("accountType")));
        accountOwnership.click();
        WebElement accountType = driver.findElement(By.id(accountInfo.get(0).get("accountOwnership")));
        accountType.click();
        WebElement accountName = driver.findElement(By.id("name"));
        accountName.sendKeys(accountInfo.get(0).get("accountName"));
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        deposit.sendKeys(accountInfo.get(0).get("initialDeposit"));
        WebElement reset = driver.findElement(By.cssSelector("[class='btn btn-danger btn-sm']"));
        reset.click();


    }

    @Then("^Verify that fields are reset to default values$")
    public void verifyThatFieldsAreResetToDefaultValues() {

        WebElement accountOwnership = driver.findElement(By.id(accountInfo.get(0).get("accountType")));
        Assert.assertFalse(accountOwnership.isSelected());
        WebElement accountType = driver.findElement(By.id(accountInfo.get(0).get("accountOwnership")));
        Assert.assertFalse(accountType.isSelected());
        WebElement accountName = driver.findElement(By.id("name"));
        Assert.assertTrue(BrowserHelper.isBlank(accountName));
        WebElement deposit = driver.findElement(By.id("openingBalance"));
        Assert.assertTrue(BrowserHelper.isBlank(deposit));
        WebElement reset = driver.findElement(By.cssSelector("[class='btn btn-danger btn-sm']"));
        reset.click();


    }

    @Then("^Verify newly created account information$")
    public void verify_newly_created_account_information() throws Throwable {

        WebElement accountName = driver.findElement(By.xpath("//div[text()='" + accountInfo.get(0).get("accountName") + "']"));
        Assert.assertTrue(accountName.isDisplayed());

        WebElement accountType = driver.findElement(By.xpath("//div[text()='" + accountInfo.get(0).get("accountName") + "']/..//div[2]/small"));
        Assert.assertEquals("Account: " + accountInfo.get(0).get("accountType"), accountType.getText().trim());

        WebElement accountOwnership = driver.findElement(By.xpath("//div[text()='" + accountInfo.get(0).get("accountName") + "']/..//div[3]/small"));
        Assert.assertEquals("Ownership: " + accountInfo.get(0).get("accountOwnership"), accountOwnership.getText().trim());

        WebElement balance = driver.findElement(By.xpath("//div[text()='" + accountInfo.get(0).get("accountName") + "']/..//div[7]"));
        Assert.assertEquals("Balance: $" + new DecimalFormat("0.00").format(Double.valueOf(accountInfo.get(0).get("initialDeposit"))), balance.getText().trim());

        WebElement transactionsHeader = driver.findElement(By.xpath("//strong[@class='card-title text-light']"));
        Assert.assertEquals("Transactions", transactionsHeader.getText().trim());

        WebElement transactionTable = driver.findElement(By.id("transactionTable"));
        Assert.assertTrue(transactionTable.isDisplayed());

        WebElement tableHeader = driver.findElement(By.xpath("//table[@id='transactionTable']//th[1]"));
        Assert.assertEquals("Date", tableHeader.getText());
        tableHeader = driver.findElement(By.xpath("//table[@id='transactionTable']//th[2]"));
        Assert.assertEquals("Category", tableHeader.getText());
        tableHeader = driver.findElement(By.xpath("//table[@id='transactionTable']//th[3]"));
        Assert.assertEquals("Description", tableHeader.getText());
        tableHeader = driver.findElement(By.xpath("//table[@id='transactionTable']//th[4]"));
        Assert.assertEquals("Amount", tableHeader.getText());
        tableHeader = driver.findElement(By.xpath("//table[@id='transactionTable']//th[5]"));
        Assert.assertEquals("Balance", tableHeader.getText());


    }


}
